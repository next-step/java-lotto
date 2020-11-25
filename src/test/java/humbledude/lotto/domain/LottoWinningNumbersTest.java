package humbledude.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningNumbersTest {
    private LottoWinningNumbers winningNumbers;

    @BeforeEach
    public void setUp() {
        winningNumbers = new LottoWinningNumbers(
                new LottoNumbers(TestHelper.setOf(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
    }

    @Test
    public void claimPrize_firstPrize() {
        LottoNumbers ticket = new LottoNumbers(
                TestHelper.setOf(1, 2, 3, 4, 5, 6));

        assertThat(winningNumbers.claimPrize(ticket)).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    public void claimPrize_secondPrize() {
        LottoNumbers ticket = new LottoNumbers(
                TestHelper.setOf(1, 2, 3, 4, 5, 7));

        assertThat(winningNumbers.claimPrize(ticket)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    public void claimPrize_thirdPrize() {
        LottoNumbers ticket = new LottoNumbers(
                TestHelper.setOf(1, 2, 3, 4, 5, 8));

        assertThat(winningNumbers.claimPrize(ticket)).isEqualTo(LottoPrize.THIRD);
    }
}
