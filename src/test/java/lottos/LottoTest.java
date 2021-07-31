package lottos;

import lottos.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}