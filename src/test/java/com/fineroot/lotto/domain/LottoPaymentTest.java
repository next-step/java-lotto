package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaymentTest {
    @Test
    @DisplayName("로또 지불금 생성")
    void create() {
        LottoPayment lottoPayment = LottoPayment.from(14000);
        assertThat(lottoPayment).isInstanceOf(LottoPayment.class);
    }

    @Test
    @DisplayName("음수 money 생성 예외 발생")
    void create_Negative_Exception() {
        assertThatThrownBy(() -> LottoPayment.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MONEY_NEGATIVE.getMessage());
    }

    @Test
    @DisplayName("lotto 장수로 반환")
    void toLottoCount() {
        assertThat(LottoPayment.from(14000).toLotteryCount()).isEqualTo(LotteryCount.from(14));
    }

    @Test
    @DisplayName("나누기 연산")
    void divide() {
        assertThat(Math.floor(LottoPayment.from(14000).divide(10000d) * 100) / 100).isEqualTo(0.71);
    }
}
