package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTotalPriceTest {
    @Test
    void LottoTotalPrice_구매금액이_생성된다() {
        assertThat(new LottoTotalPrice("1000")).isEqualTo(new LottoTotalPrice(1000));
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
    void LottoTotalPrice_구매금액이_숫자가_아닌경우() {
        assertThatThrownBy(() -> new LottoTotalPrice("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoTotalPrice_구매금액이_음수인_경우() {
        assertThatThrownBy(() -> new LottoTotalPrice(-1000)).isInstanceOf(IllegalArgumentException.class);
    }
}