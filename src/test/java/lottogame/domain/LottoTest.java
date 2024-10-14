package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @DisplayName("일치하는 번호 개수를 구한다.")
    @Test
    void countMatchingNumbers() {
        Lotto lotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        Lotto anotherLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,7,8,9"));

        assertEquals(3, lotto.countMatchingNumbers(anotherLotto));
    }
}
