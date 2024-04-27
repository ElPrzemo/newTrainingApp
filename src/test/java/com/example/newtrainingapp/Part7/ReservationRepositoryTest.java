package com.example.newtrainingapp.Part7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void should_return_2_reservation_when_search_fo_all(){
        //given
        testEntityManager.persist(new Reservation(1L,
                "res1",
                "hotel1",
                2,
                Standard.NORMAL,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));
        testEntityManager.persist(new Reservation(2L,
                "res2",
                "hotel1",
                2,
                Standard.EXCLUSIVE,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));

        //when
        List<Reservation> results = reservationRepository.findAll();

        //then
        assertEquals(2, results.size());
    }

    @Test
    void should_add_1_reservation_when_save_it_via_repository() {
        //given
        Reservation reservation = new Reservation(1L,
                "res1",
                "hotel1",
                2,
                Standard.NORMAL,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1));

        //when
        reservationRepository.save(reservation);

        //then
        Reservation result = testEntityManager.find(Reservation.class, 1L);
        assertEquals(reservation, result);
    }

    @ParameterizedTest
    @ArgumentsSource(SearchByStandardAndPriceArgumentsProvider.class)
    void should_return_1_reservation_when_search_by_exclusive_standard_with_price_300(List<Reservation> input,
                                                                                      Standard standard,
                                                                                      float price,
                                                                                      List<Reservation> expected) {
        //given
        input.forEach(testEntityManager::persist);

        //when
        List<Reservation> results = reservationRepository.findAllByStandardAndPrice(standard, price);

        //then
        assertEquals(expected.size(), results.size());
        assertEquals(expected, results);
    }

    @Test
    void should_return_reservation_with_name_res1_when_search_by_reservation_name() {
        //given
        testEntityManager.persist(new Reservation(1L,
                "res1",
                "hotel1",
                2,
                Standard.NORMAL,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));
        testEntityManager.persist(new Reservation(2L,
                "res2",
                "hotel1",
                2,
                Standard.EXCLUSIVE,
                200.0f,
                LocalDate.now(),
                LocalDate.now().plusDays(1)));

        //when
        List<Reservation> results = reservationRepository.findAllByName("res1");

        //then
        assertEquals(1, results.size());
        assertEquals("res1", results.get(0).getName());
    }

    @ParameterizedTest
    @ArgumentsSource(SearchByDateArgumentsProvider.class)
    void should_return_n_reservation_when_looking_for_reservations_in_specified_data(
            List<Reservation> input,
            LocalDate date,
            List<Reservation> expectedResult) {

        //given
        input.forEach(testEntityManager::persist);

        //when
        List<Reservation> results = reservationRepository.findAllByEndDateGreaterThanEqualAndStartDateLessThanEqual(date, date);

        //then
        assertEquals(expectedResult.size(), results.size());
        assertEquals(expectedResult, results);

    }
}
public class SearchByStandardAndPriceArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(4L, "res4", "hotel1", 2, Standard.EXCLUSIVE, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1))
                        ),
                        Standard.NORMAL,
                        300.0f,
                        Arrays.asList(
                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1))
                        )
                ),
                Arguments.arguments(
                        Collections.emptyList(),
                        Standard.NORMAL,
                        200.0f,
                        Collections.emptyList()
                ),
                Arguments.arguments(
                        Arrays.asList(
                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(4L, "res4", "hotel1", 2, Standard.EXCLUSIVE, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1))
                        ),
                        Standard.EXCLUSIVE,
                        400.0f,
                        Collections.emptyList()
                )
        );
    }
}