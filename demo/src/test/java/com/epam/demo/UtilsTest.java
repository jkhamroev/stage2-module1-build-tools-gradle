package com.epam.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of("1", "2", "3", "4", "5"), true),
                Arguments.of(List.of("0", "2", "3", "4", "5"), false),
                Arguments.of(List.of("-3", "7", "0", "-9", "4", "-2", "6"), false)
        );
    }

    @ParameterizedTest(name = "isAllPositiveNumbers_{0}_Test")
    @MethodSource(value = "testCases")
    void isAllPositiveNumbersTest(List<String> numbers, boolean expected) {
        boolean actual = Utils.isAllPositiveNumbers(numbers);
        assertEquals(actual, expected);
    }
}
