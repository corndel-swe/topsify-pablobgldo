package org.example;

import java.nio.file.*;
import java.util.List;

public class FileIO {
    Path filePath;

    public FileIO(String fileName) {
        this.filePath = Paths.get("reports",fileName);
    }
}