package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoUtilTest {

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

    @DisplayName("Lotto 결과 숫자를 입력하면 리스트로 응답한다.")
    @Test
    public void lottoUtil_결과_리스트_테스트() {
        assertEquals(LottoUtils.lottoResultNumberList("1, 5, 42, 8, 10, 23").size(), 6);
    }

    @DisplayName("Lotto 결과 숫자가 1~45가 아니면 Exception 이 발생한다.")
    @Test
    public void lottoUtil_결과_숫자_범위_테스트() {
        assertThatThrownBy(() -> LottoUtils.lottoResultNumberList("1, 5, 42, 46, 10, 23"))
                .isInstanceOf(InputMismatchException.class);
    }

    @DisplayName("Lotto 결과 숫자가 6개가 아니면 Exception 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 5, 42, 46, 23", "1, 5, 42, 46, 23, 4, 7"})
    public void lottoUtil_결과_숫자_갯수_테스트(String numbers) {
        assertThatThrownBy(() -> LottoUtils.lottoResultNumberList(numbers))
                .isInstanceOf(InputMismatchException.class);
    }
}
