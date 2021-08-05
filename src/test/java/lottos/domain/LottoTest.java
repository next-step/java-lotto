package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void 로또_랜덤_생성() {
        Lotto lotto = new Lotto(new LottoRandomGenerator());

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