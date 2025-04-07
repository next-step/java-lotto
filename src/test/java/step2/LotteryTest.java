package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.generate.Generate;
import step2.lottery.Lottery;
import step2.lottery.LotteryNumber;
import step2.lottery.Lotterys;
import step2.winning.PrizeWinningNumber;
import step2.winning.Winning;
import step2.winning.WinningResults;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    @DisplayName("6개 번호가 일치할 경우, 1등 당첨이다.")
    void matchFirstTest() {
        Set<LotteryNumber> lottoNumbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        );
        Lottery lotto = new Lottery(lottoNumbers);

        PrizeWinningNumber prize = new PrizeWinningNumber("1,2,3,4,5,6", 7);
        assertThat(lotto.matchWith(prize)).isEqualTo(Winning.FIRST);
    }
    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치할 경우, 2등 당첨이다.")
    void matchSecondTest() {
        Set<LotteryNumber> lottoNumbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(7)
        );
        Lottery lotto = new Lottery(lottoNumbers);

        PrizeWinningNumber prize = new PrizeWinningNumber("1,2,3,4,5,6", 7);
        assertThat(lotto.matchWith(prize)).isEqualTo(Winning.SECOND);
    }

    @Test
    @DisplayName("당첨 번호가 3개 이하일 경우, None 이다.")
    void matchNoneTest() {
        Set<LotteryNumber> lottoNumbers = Set.of(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(13),
                new LotteryNumber(14),
                new LotteryNumber(15),
                new LotteryNumber(18)
        );
        Lottery lotto = new Lottery(lottoNumbers);

        PrizeWinningNumber prize = new PrizeWinningNumber("1,2,3,4,5,6", 7);
        assertThat(lotto.matchWith(prize)).isEqualTo(Winning.NONE);
    }
}
