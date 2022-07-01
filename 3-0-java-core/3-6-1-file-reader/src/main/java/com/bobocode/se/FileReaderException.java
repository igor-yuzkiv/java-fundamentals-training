package com.bobocode.se;

import java.io.IOException;

public class FileReaderException extends RuntimeException {
    public FileReaderException(String message, Exception e) {
        super(message, e);
    }
}
