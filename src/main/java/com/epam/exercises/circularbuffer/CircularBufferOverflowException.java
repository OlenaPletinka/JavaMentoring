package com.epam.exercises.circularbuffer;

class CircularBufferOverflowException extends RuntimeException {
    CircularBufferOverflowException(String message) {
        super(message);
    }
}
