package com.fineroot.lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LotteryCountTest {

    @Test
    @DisplayName("생성")
    void from() {
        assertThat(LotteryCount.from(1)).isInstanceOf(LotteryCount.class);
    }

    @Test
    @DisplayName("음수입력시 예외발생")
    void from_should_throw_exception() {
        assertThatThrownBy(() -> LotteryCount.from(-1)).hasMessageContaining(
                ExceptionMessage.LOTTERY_COUNT_NEGATIVE_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("다른 LotteryCount 보다 작은지 검증")
    @CsvSource({"1,2,true", "2,1,false", "2,2,false"})
    void isLessThan(int from, int other, boolean expected) {
        assertThat(LotteryCount.from(from).isLessThan(LotteryCount.from(other))).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("다른 특정 정수 값보다 같거나 큰지 검증")
    @CsvSource({"1,true", "2,false", "3,false"})
    void isGreaterThanFromInteger(int other, boolean expected) {
        assertThat(LotteryCount.from(2).isGreaterThanFromInteger(other)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다른 LotteryCount의 value만큼 뺀 LotteryCount 반환")
    void subtract() {
        assertThat(LotteryCount.from(2).subtract(LotteryCount.from(2))).isEqualTo(LotteryCount.from(0));
    }
}