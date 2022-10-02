package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseMoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"10000, 10", "55000,55"}, delimiter = ',')
    @DisplayName("구매금액으로 구매할 수 있는 로또 갯수 구하기")
    void get_lotto_count(int money, int count) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);

        assertThat(purchaseMoney.getLottoCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 999, 1500, 9999})
    @DisplayName("거스름돈이 생기면 에러")
    void get_lotto_count_when_change(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseMoney(money));
    }

    @Test
    @DisplayName("1개 사서 일등 당첨일때 로또 수익률 계산하기")
    void calculate_earning_rate_when_buy_1_and_win_1() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(1000);

        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(LottoResult.FIRST, 1);
        LottoResult lottoResult = new LottoResult(result);
        //when
        float expected = LottoResult.FIRST_PRIZE / (float) Lotto.PRICE;
        //then
        assertThat(purchaseMoney.getEarningRate(lottoResult)).isEqualTo(expected);
    }

    @Test
    @DisplayName("2개 사서 이등 당첨일때 로또 수익률 계산하기")
    void calculate_earning_rate_when_buy_2_and_win_2() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);

        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(LottoResult.SECOND, 1);
        LottoResult lottoResult = new LottoResult(result);
        //when
        float expected = LottoResult.SECOND_PRIZE / (float) (Lotto.PRICE * 2);
        //then
        assertThat(purchaseMoney.getEarningRate(lottoResult)).isEqualTo(expected);
    }

}