package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPaymentTest {

    @Test
    void 로또_구매_금액_객체_정상_생성_여부_테스트() {
        LottoPayment lottoPayment = new LottoPayment(10000);
        assertThat(lottoPayment).isEqualTo(new LottoPayment(10000));
    }

    @Test
    void 로또_구매_금액이_1000_보다_작은_금액_입력_시_에러_발생_테스트() {
        assertThatThrownBy(() -> new LottoPayment(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 가능 금액은 1000원 이상 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1100:1", "2000:2", "2200:2", "2500:2", "4000:4"}, delimiter = ':')
    void 구매금액에_따라_구매_매수_정상_반환_여부_테스트(int value, int excepted) {
        LottoPayment lottoPayment = new LottoPayment(value);
        int lottoBuyQuantity = lottoPayment.calcLottoBuyQuantity();
        assertThat(lottoBuyQuantity).isEqualTo(excepted);
    }
}
