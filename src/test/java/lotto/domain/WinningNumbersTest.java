package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @Test
    @DisplayName("먼저 뽑힌 당첨 번호 6개와 일치하는 보너스 번호가 뽑히면 에러 발생한다.")
    void isDuplicatedTest() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 중에서 로또 번호와 일치하는 것이 있으면 False 이다.")
    void hasBonusTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 7");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "10");
        assertThat(winningNumbers.hasBonusNumber(lotto)).isFalse();
    }
}
