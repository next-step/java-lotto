package autolotto.machine.winning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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
    void 당첨금을_받을_수_없는_경우_예외를_던진다() {
        int matchCount = 2;
        boolean anyBonusBallMatched = false;

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Winning.winningOf(matchCount, anyBonusBallMatched));
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
}
