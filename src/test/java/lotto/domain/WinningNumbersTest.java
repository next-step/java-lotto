package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("당첨번호는_1~45범위이고_6개이다")
    @Test
    void validateWinningNumbers() {
        final int bonusBall = 12;
        assertDoesNotThrow(
            () -> new WinningNumbers(winningNumbers, bonusBall));
    }

    @DisplayName("보너스볼의 범위는 1~45까지이다.")
    @Test
    void validateBonusBallRange() {
        final int bonusBall = 78;
        assertThrows(IllegalArgumentException.class,
            () -> new WinningNumbers(winningNumbers, bonusBall));
    }

    @Test
    void 로또넘버중_당첨넘버와_일치하는_수에_따라_당첨결과가_나온다_1등() {
        final LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6),
            40);

        LottoRank given = winningNumbers.getRankForLottoTicket(lottoTicket);
        assertThat(given).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 로또넘버중_당첨넘버와_일치하는_수에_따라_당첨결과가_나온다_2등() {
        final LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7),
            6);

        LottoRank given = winningNumbers.getRankForLottoTicket(lottoTicket);
        assertThat(given).isEqualTo(LottoRank.SECOND);
    }
}
