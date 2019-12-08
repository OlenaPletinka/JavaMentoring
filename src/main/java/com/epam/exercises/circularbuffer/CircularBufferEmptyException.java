package com.epam.exercises.circularbuffer;

class CircularBufferEmptyException extends RuntimeException {
    CircularBufferEmptyException(String message) {
        super(message);
    }
}
