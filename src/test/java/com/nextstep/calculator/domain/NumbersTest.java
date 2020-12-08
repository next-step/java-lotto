package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;
import com.nextstep.calculator.domain.exceptions.InvalidNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
