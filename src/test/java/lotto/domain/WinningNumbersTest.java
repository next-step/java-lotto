package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    @DisplayName("1등 당첨 확인 테스트")
    public void rankFirstCheckTest() {
        WinningNumbers winningNumbers = WinningNumbers.getInstance(Arrays.asList(1, 2, 3, 4, 5, 6), 1);
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank result = winningNumbers.getMatchResult(lotto);

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 당첨 확인 테스트")
    public void rankSecondCheckTest() {
        WinningNumbers winningNumbers = WinningNumbers.getInstance(Arrays.asList(1, 2, 3, 4, 5, 40), 6);
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank result = winningNumbers.getMatchResult(lotto);

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("미당첨 확인 테스트")
    public void loseGameCheckTest() {
        WinningNumbers winningNumbers = WinningNumbers.getInstance(Arrays.asList(1, 2, 10, 12, 23, 35), 7);
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank result = winningNumbers.getMatchResult(lotto);

        assertThat(result).isEqualTo(Rank.LOSE);
    }

}
