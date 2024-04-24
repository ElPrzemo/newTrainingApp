package com.example.newtrainingapp.part3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "file_name")
    String fileName;

    @Column(name="extension")
    private String extension;

    @Column(name = "size_in_kb")
    private Integer sizeInKb;

    @Column(name="content")
    private String content;

}
