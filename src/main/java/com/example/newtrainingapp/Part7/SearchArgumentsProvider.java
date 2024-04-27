package com.example.newtrainingapp.Part7;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.stream.Stream;
//
//public class SearchByDateArgumentsProvider implements ArgumentsProvider {
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
//        return Stream.of(
//                Arguments.arguments(
//                        Arrays.asList(
//                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3)),
//                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.of(2022, 2, 10), LocalDate.of(2022, 1, 15)),
//                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.of(2022, 3, 20), LocalDate.of(2022, 1, 25)),
//                                new Reservation(4L, "res4", "hotel1", 2, Standard.EXCLUSIVE, 300.0f, LocalDate.of(2022, 4, 6), LocalDate.of(2022, 4, 9))
//                        ),
//                        LocalDate.of(2022, 1, 2),
//                        Arrays.asList(
//                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3))
//                        )
//                ),
//                Arguments.arguments(
//                        Arrays.asList(
//                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 10)),
//                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 7)),
//                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.of(2022, 3, 20), LocalDate.of(2022, 1, 25)),
//                                new Reservation(4L, "res4", "hotel1", 2, Standard.EXCLUSIVE, 300.0f, LocalDate.of(2022, 4, 6), LocalDate.of(2022, 4, 9))
//                        ),
//                        LocalDate.of(2022, 1, 6),
//                        Arrays.asList(
//                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 10)),
//                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 7))
//                        )
//                ),
//                Arguments.arguments(
//                        Collections.emptyList(),
//                        LocalDate.of(2022, 1, 6),
//                        Collections.emptyList()
//                )
//        );
//    }
//}