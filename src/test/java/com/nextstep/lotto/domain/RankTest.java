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
    @DisplayName("맞춘 LottoNumber 수와 보너스 숫자 여부에 따라 Rank를 찾을 수 있다.")
    @ParameterizedTest
    @MethodSource("findTestResource")
    void findTest(int numberOfMatchedNumber, boolean hasBonus, Rank expected) {
        assertThat(Rank.find(numberOfMatchedNumber, hasBonus)).isEqualTo(expected);
    }
    public static Stream<Arguments> findTestResource() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH)
        );
    }

    @DisplayName("존재하지 않는 당첨 결과를 찾으려는 경우 꽝 반환")
    @ParameterizedTest
    @MethodSource("findFailTestResource")
    void findFailTest(int numberOfMatchedNumber, boolean hasBonus) {
        assertThat(Rank.find(numberOfMatchedNumber, hasBonus)).isEqualTo(Rank.NOTHING);
    }
    public static Stream<Arguments> findFailTestResource() {
        return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(7, false)
        );
    }

    @DisplayName("복수의 랭크에 대한 상금 합산 연산이 가능하다.")
    @Test
    void multiplyPrizeTest() {
        Long count = 3L;
        Money expectedMoney = new Money(2000000000L * 3L);

        assertThat(Rank.FIRST.multiplyPrize(count)).isEqualTo(expectedMoney);
    }
}
