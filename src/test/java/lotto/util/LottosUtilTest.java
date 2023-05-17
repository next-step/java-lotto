package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosUtilTest {

    @DisplayName("Lotto 가격을 전달하면 구매 횟수를 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "16000:16", "6000:6"}, delimiterString = ":")
    public void lottoUtil_구매_횟수_테스트(int price, int games) {

        assertEquals(LottoUtils.getLottoGameCount(price), games);
    }

    @DisplayName("Lotto 1000원 미만이면 Exception 이 발생한다.")
    @Test
    public void lottoUtil_구매_가격_테스트() {
        assertThatThrownBy(() -> LottoUtils.getLottoGameCount(500))
                .isInstanceOf(InputMismatchException.class);
    }

    @DisplayName("로또 당첨 금액과 구입 금액을 전달하여 수익률을 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:5000:0", "5000:5000:1", "15000:30000:0.5"}, delimiterString = ":")
    public void lottoUtil_정답_게임_수익률_테스트(Long totalPrice, int buyPrice, double rate) {
        assertThat(LottoUtils.calRateOfReturn(totalPrice, buyPrice)).isEqualTo(rate);
    }

}
