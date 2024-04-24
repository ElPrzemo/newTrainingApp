package com.example.newtrainingapp.part3;

import org.springframework.data.repository.CrudRepository;

import java.io.File;
import java.util.List;
import java.util.UUID;

public interface FileDataRepository extends CrudRepository<FileData, UUID> {

    List<FileData> findAllBy();

}
