package lotto;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @DisplayName("넘겨받은 두개의 Set에서 겹치는 숫자의 개수 테스트")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', '3,4,5,6,7,8', FOURTH",
            "'10,20,30,40,41,42', '1,2,3,4,5,6', MISS",
            "'1,2,3,4,5,7', '1,2,3,4,5,6', SECOND",
            "'1,2,3,4,5,6', '1,2,3,4,5,6', FIRST"
    })
    void countCommonNumbers_ShouldReturnCorrectLottoPrize(String lottoNumbersStr, String winningNumbersStr,
                                                          LottoPrize exprectedLottoPrize) {
        Lotto lotto = new Lotto(lottoNumbersStr);
        WinningLotto winningLotto = new WinningLotto(winningNumbersStr, "7");

        lotto.setLottoPrize(winningLotto);

        assertEquals(exprectedLottoPrize, lotto.getLottoPrize());
    }
}

