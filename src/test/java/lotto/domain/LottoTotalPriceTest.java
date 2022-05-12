package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTotalPriceTest {
    @Test
    void LottoTotalPrice_구매금액이_생성된다() {
        assertThat(LottoTotalPrice.create("1000")).isEqualTo(new LottoTotalPrice(1000));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "14000, 14",
            "1000, 1",
            "5000, 5"
    })
    void getPurchaseLottoCount_로또갯수_구하기(int totalPrice, int lottoCount) {
        assertThat(new LottoTotalPrice(totalPrice).getPurchaseLottoCount()).isEqualTo(lottoCount);
    }

    @Test
    void LottoTotalPrice_구매금액이_음수인_경우() {
        assertThatThrownBy(() -> new LottoTotalPrice(-1000)).isInstanceOf(IllegalArgumentException.class);
    }



    @ParameterizedTest
    @CsvSource(value = {
            "100, 1, false",
            "1000, 1000, false",
            "1000, 1001, true"
    })
    void LottoTotalPrice_총구매금액과_구입한_로또갯수_금액_비교(int totalPrice, int countPurchaseAmount, boolean trueOrFalse) {
        assertThat(new LottoTotalPrice(totalPrice).lessThan(countPurchaseAmount)).isEqualTo(trueOrFalse);
    }
}