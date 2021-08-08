package lottos.domain;

import lottos.domain.exceptions.LottoDuplicationNumberException;
import lottos.domain.exceptions.LottoSizeIncorrectException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7,8", "1,2,3,4,5,6:7,8,9"}, delimiter = ':')
    void 보너스_넘버가_여러개인_로또면_에러(final String numbersText, final String bonusText) {
        assertThrows(NumberFormatException.class, () -> new WinningLotto(numbersText, bonusText));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,6:3"}, delimiter = ':')
    void 로또와_보너스넘버가_중첩되는경우_에러(final String numbersText, final String bonusText) {
        assertThrows(LottoDuplicationNumberException.class, () -> new WinningLotto(numbersText, bonusText));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6,7:6", "1,2,3,4,5:3", ":5"}, delimiter = ':')
    void 로또_개수가_올바르지_않을경우(final String numbersText, final String bonusText) {
        assertThrows(LottoSizeIncorrectException.class, () -> new WinningLotto(numbersText, bonusText));
    }

    @Test
    void 로또_비교() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(4, 5, 6, 7, 8, 9), 10);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResult lottoResult = winningLotto.match(lotto);
        assertEquals(lottoResult.getPrize(), LottoPrize.FIFTH);
    }
}
