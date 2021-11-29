package com.kkambi.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("숫자 형식의 문자열 리스트를 받아 생성된다")
    @Test
    void createNumbersWithNumberList() {
        // given
        String[] tokens = {"1", "2", "3"};
        Elements elements = new Elements(tokens);

        // when
        List<Number> numbers = new Numbers(elements).getNumbers();
        List<Integer> result = numbers.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList());

        // then
        assertThat(result).containsExactlyElementsOf(Arrays.asList(1, 2, 3));
    }
}
