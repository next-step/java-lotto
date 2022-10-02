package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("1개 사서 일등 당첨일때 로또 수익률 계산하기")
    void calculate_earning_rate_when_buy_1_and_win_1() {
        //given
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(LottoResult.FIRST, 1);
        LottoResult lottoResult = new LottoResult(result, 1);
        //when
        float expected = LottoResult.FIRST_PRIZE / (float) Lotto.PRICE;
        //then
        assertThat(lottoResult.getEarningRate()).isEqualTo(expected);
    }

    @Test
    @DisplayName("2개 사서 이등 당첨일때 로또 수익률 계산하기")
    void calculate_earning_rate_when_buy_2_and_win_2() {
        //given
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(LottoResult.SECOND, 1);
        LottoResult lottoResult = new LottoResult(result, 2);
        //when
        float expected = LottoResult.SECOND_PRIZE / (float) (Lotto.PRICE * 2);
        //then
        assertThat(lottoResult.getEarningRate()).isEqualTo(expected);
    }

}