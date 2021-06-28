package lottogame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {

    Lottos lottos = new Lottos();

    LottoMachine lottoMachine = new LottoMachine();
    @DisplayName("보너스 당첨 여부 테스트")
    @Test
    void getBuyCount() {

        assertAll("operator",
                () -> assertTrue(lottos.isBonus(lottoMachine.generateLotto("1,2,3,4,5,6"), new LottoNumber(6))),
                () -> assertFalse(lottos.isBonus(lottoMachine.generateLotto("1,2,3,4,5,6"), new LottoNumber(7)))
        );
    }

    @DisplayName("당첨 개수 테스트")
    @Test
    void getNumberOfWinnings() {
        Lotto lotto = lottoMachine.generateLotto("1,2,3,4,5,6");
        assertAll("operator",
                () -> assertEquals(lottos.getNumberOfWinnings(lotto, lottoMachine.generateLotto("1,2,3,4,5,6")), 6),
                () -> assertEquals(lottos.getNumberOfWinnings(lotto, lottoMachine.generateLotto("1,2,3,4,5,7")), 5),
                () -> assertEquals(lottos.getNumberOfWinnings(lotto, lottoMachine.generateLotto("1,2,3,4,7,8")), 4),
                () -> assertEquals(lottos.getNumberOfWinnings(lotto, lottoMachine.generateLotto("1,2,3,7,8,9")), 3),
                () -> assertEquals(lottos.getNumberOfWinnings(lotto, lottoMachine.generateLotto("1,2,7,8,9,10")), 2),
                () -> assertEquals(lottos.getNumberOfWinnings(lotto, lottoMachine.generateLotto("7,8,9,10,11,12")), 0)
        );
    }

}
