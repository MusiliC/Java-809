package com.javatwo.lambda;

public interface Operation<T> {
    T operate(T value1, T value2);
}
