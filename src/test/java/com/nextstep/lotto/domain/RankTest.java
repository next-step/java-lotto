package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {
    @DisplayName("맞춘 LottoNumber 수에 맞는 LottoPrize를 받을 수 있다.")
    @ParameterizedTest
    @MethodSource("findTestResource")
    void findTest(int numberOfMatchedNumber, Rank expected) {
        assertThat(Rank.find(numberOfMatchedNumber)).isEqualTo(expected);
    }
    public static Stream<Arguments> findTestResource() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FOURTH)
        );
    }

    @DisplayName("존재하지 않는 당첨 결과를 찾으려는 경우 꽝 반환")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 7})
    void findFailTest(int invalidValue) {
        assertThat(Rank.find(invalidValue)).isEqualTo(Rank.NOTHING);
    }

    @DisplayName("복수의 랭크에 대한 상금 합산 연산이 가능하다.")
    @Test
    void multiplyPrizeTest() {
        Long count = 3L;
        Money expectedMoney = new Money(2000000000L * 3L);

        assertThat(Rank.FIRST.multiplyPrize(count)).isEqualTo(expectedMoney);
    }
}
