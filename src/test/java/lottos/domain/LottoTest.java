package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private LottoGenerator generator = new LottoRandomGenerator();

    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource(value = {"1,2,3,4,5:6", "1,2,3,4,5,6,7"}, delimiter = ':')
    void 여섯개의_숫자로_이루어진_로또가_아니면_에러(final String numbersText) {
        assertThrows(LottoSizeIncorrectException.class, () -> new Lotto(numbersText));
    }

    @Test
    void 로또_랜덤_생성() {
        Lotto lotto = new Lotto(generator.generate());

        assertEquals(lotto.elements().size(), 6);
        for (Integer number : lotto.elements()) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    void 로또_비교() {
        Lotto lastWeekWinningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResult lottoResult = lastWeekWinningLotto.match(lotto);
        assertEquals(lottoResult.getPrize(), Prize.THREE);
    }

    @Test
    void 로또_생성_올바르지않음() {
        assertThrows(LottoSizeIncorrectException.class, () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
