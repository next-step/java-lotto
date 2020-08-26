package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

class LotteryTest {

    @Test
    @DisplayName("Lottery 인스턴스 생성 전 유효성 체크 테스트 - 입력값 중복 및 개수 확인")
    void testValidateNumbersByNumberCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lottery(numbers)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Lottery 인스턴스 생성 전 유효성 체크 테스트 - 입력값 범위 확인")
    void testValidateNumbersByNumber() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lottery(numbers)).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @DisplayName("두 Lottery 인스턴스 간 번호 비교")
    @CsvSource(value = {
            "1:2:3:4:5:6:6",
            "1:2:3:4:5:7:5",
            "1:2:3:4:7:8:4",
            "1:2:3:7:8:9:3",
            "1:2:7:8:9:10:2",
            "1:7:8:9:10:11:1",
            "7:8:9:10:11:12:0",
    }, delimiter = ':')
    void compareMatchingNumbers(int num1, int num2, int num3, int num4, int num5, int num6, int expected) {
        Lottery left = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottery right = new Lottery(Arrays.asList(num1, num2, num3, num4, num5, num6));
        then(left.compareMatchingNumbers(right)).isEqualTo(expected);
    }
}
