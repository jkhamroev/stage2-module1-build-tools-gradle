package com.epam.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList("1", "2", null)), false),
                Arguments.of(List.of(), false),
                Arguments.of(List.of("088"), false),
                Arguments.of(List.of("11.22", "2", "33", "87"), true),
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
