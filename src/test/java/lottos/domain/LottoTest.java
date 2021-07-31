package lottos.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void 로또_랜덤_생성() {
        Lotto lotto = new Lotto();

        assertEquals(lotto.getElements().size(), 6);
        for (Integer number : lotto.getElements()) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    @DisplayName("로또_비교")
    void 로또_비교() {
        Lotto lastWeekWinningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int matchCount = lastWeekWinningLotto.match(lotto);
        Assertions.assertEquals(matchCount, 3);
    }
}