package com.example.newtrainingapp.part3;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDataCollection {
    private List<FileData> filesData;
}