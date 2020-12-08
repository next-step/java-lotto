package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;
import com.nextstep.calculator.domain.exceptions.InvalidNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {
    @DisplayName("Number 컬렉션을 인자로 받아서 생성할 수 있다.")
    @Test
    void createTest() {
        List<Number> numberValues = Arrays.asList(Number.of("1"), Number.of("2"));

        Numbers numbers = new Numbers(numberValues);

        assertThat(numbers).isEqualTo(new Numbers(numberValues));
    }

    @DisplayName("한 개 이상의 숫자 컬렉션으로만 객체를 생성할 수 있다.")
    @Test
    void createFailTest() {
        List<Number> numberValues = new ArrayList<>();

        assertThatThrownBy(() -> new Numbers(numberValues))
                .isInstanceOf(InvalidNumbersException.class);
    }

    @DisplayName("속한 Number들의 합을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("sumTestResource")
    void sumTest(Numbers numbers, Number expected) {
        assertThat(numbers.sum()).isEqualTo(expected);
    }
    public static Stream<Arguments> sumTestResource() {
        return Stream.of(
                Arguments.of(
                        new Numbers(Arrays.asList(Number.of("1"), Number.of("0"), Number.of("2"))),
                        Number.of("3")
                ),
                Arguments.of(
                        new Numbers(Arrays.asList(Number.of("1"), Number.of("3"), Number.of("2"))),
                        Number.of("6")
                )
        );
    }
}
