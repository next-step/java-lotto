package autolotto.machine.winning;

import autolotto.machine.LottoUtil;
import autolotto.machine.lotto.Lotto;
import autolotto.machine.lotto.LottoNumber;
import autolotto.machine.lotto.LottoWallet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WinningTest {

    @Test
    void 매칭_개수가_3_일_경우_당첨금이_5000원임을_알려준다() {
        int matchCount = 3;
        boolean anyBonusBallMatched = false;

        int winnings = Winning.winningOf(matchCount, anyBonusBallMatched).winningMoney();

        Assertions.assertThat(winnings).isEqualTo(5000);
    }

    @Test
    void 당첨금을_받을_수_없는_경우_0원임을_알려준다() {
        int matchCount = 2;
        boolean anyBonusBallMatched = false;

        Winning zero = Winning.winningOf(matchCount, anyBonusBallMatched);

        Assertions.assertThat(zero).isEqualTo(Winning.ZERO);
    }

    @Test
    void 최소_당첨금을_받을_수_있는_matchCount_를_알려준다() {
        int minimumMatchCount = Winning.minWinningMatchCount();

        Assertions.assertThat(minimumMatchCount).isEqualTo(3);
    }

    @Test
    void 당첨번호와_5개_일치하고_보너스_볼_또한_일치할_경우인_2등_당첨금액을_알려준다() {
        int matchCount = 5;
        boolean isBonusBallMatched = true;

        Winning winnings = Winning.winningOf(matchCount, isBonusBallMatched);

        Assertions.assertThat(winnings).isEqualTo(Winning.FIVE_BONUS);
    }

    @ParameterizedTest
    @EnumSource(value = Winning.class, names = {"THREE", "FOUR", "SIX"})
    void 보너스볼이_일치하더라도_당첨번호와_4개_이하로_일치할_경우_보너스볼이_일치하지_않는_것과_당첨금액이_같다(Winning winning) {
        int matchCount = winning.matchNumber();
        boolean isBonusBallMatched = true;

        int winnings = Winning.winningOf(matchCount, isBonusBallMatched).winningMoney();

        Assertions.assertThat(winnings).isEqualTo(Winning.winningOf(matchCount, !isBonusBallMatched).winningMoney());
    }

    @Test
    void Winning_에게_로또와_당첨번호_를_전달하면_당첨금을_알려준다() {
        Lotto lotto = new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        Winning winning = Winning.winningOf(lotto, winningNumbers);

        Assertions.assertThat(winning).isEqualTo(Winning.SIX);
    }

    @Nested
    class 총_당첨금액_테스트 {
        private final WinningNumbers fixedWinningNumbers = new WinningNumbers(
                LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 3, 40, 41, 42)),
                new LottoNumber(11));

        @Test
        void Winning_에게_일련의_로또와_당첨번호를_전달하면_총_당첨금액을_알려준다() {

            LottoWallet wallet = new LottoWallet(Arrays.asList(
                    new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 22, 32, 24, 25, 26))),
                    new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 23, 24, 25, 27))),
                    new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 3, 24, 25, 28)))));
            int expectedTotalWinnings = Winning.THREE.winningMoney();

            int totalWinnings = Winning.totalAmountOf(wallet.allLotteries(), fixedWinningNumbers);

            Assertions.assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
        }

        @Test
        void 당첨로또와_당첨이아닌_로또가_섞여있는_경우_총_당첨금액을_알려준다() {
            List<Lotto> wallet = Arrays.asList(
                    new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 22, 32, 24, 25, 26))),
                    new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 23, 24, 25, 27))),
                    new Lotto(LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 3, 24, 25, 28))));
            int expectedTotalWinnings = Winning.THREE.winningMoney();

            int totalWinnings = Winning.totalAmountOf(wallet, fixedWinningNumbers);

            Assertions.assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
        }

    }

}
