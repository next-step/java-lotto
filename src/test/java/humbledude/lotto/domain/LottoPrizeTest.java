package humbledude.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    private LottoWinningNumbers winningNumbers;

    @BeforeEach
    public void setUp() {
        winningNumbers = new LottoWinningNumbers(
                new LottoNumberSet(TestHelper.setOf(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
    }

    @Test
    public void firstPrize() {
        LottoNumberSet ticket = new LottoNumberSet(
                TestHelper.setOf(1, 2, 3, 4, 5, 6));

        assertThat(LottoPrize.of(winningNumbers.getMatchedCountWith(ticket), winningNumbers.isBonusMatched(ticket)))
                .isEqualTo(LottoPrize.FIRST);
    }

    @Test
    public void secondPrize() {
        LottoNumberSet ticket = new LottoNumberSet(
                TestHelper.setOf(1, 2, 3, 4, 5, 7));

        assertThat(LottoPrize.of(winningNumbers.getMatchedCountWith(ticket), winningNumbers.isBonusMatched(ticket)))
                .isEqualTo(LottoPrize.SECOND);
    }

    @Test
    public void thirdPrize() {
        LottoNumberSet ticket = new LottoNumberSet(
                TestHelper.setOf(1, 2, 3, 4, 5, 8));

        assertThat(LottoPrize.of(winningNumbers.getMatchedCountWith(ticket), winningNumbers.isBonusMatched(ticket)))
                .isEqualTo(LottoPrize.THIRD);
    }
}
