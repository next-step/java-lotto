package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnerNumbersTest {

    @Test
    void 당첨_번호_갯수는_6개_확인() {
        Assertions.assertThatThrownBy(() -> new WinnerNumbers(Number.of(1, 2), Number.of(3)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨번호의 갯수는 6개 입니다.");
    }

    @Test
    void 승리_번호와_일치한_갯수_확인() {
        WinnerNumbers winnerNumbers = new WinnerNumbers(Number.of(1, 2, 3, 4, 5, 6), Number.of(7));
        Assertions.assertThat(winnerNumbers.match(Number.of(1, 2, 3, 4, 5, 6)))
            .isEqualTo(6);
    }

    @Test
    void 보너스_번호_포함여부_확인() {
        WinnerNumbers winnerNumbers = new WinnerNumbers(Number.of(1, 2, 3, 4, 5, 6), Number.of(7));
        Assertions.assertThat(winnerNumbers.hasBonus(Number.of(1, 2, 3, 4, 5, 6)))
            .isFalse();
    }

}