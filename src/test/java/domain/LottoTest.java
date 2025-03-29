package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {
    @Test
    @DisplayName("로또 번호와 당첨 번호의 일치 개수를 반환해야한다.")
    void 로또_번호_당첨_번호_일치_개수() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto.matchCount(winningNumber)).isEqualTo(6);
    }
}