package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.generate.Generate;
import step2.lottery.LotteryNumber;
import step2.lottery.Lotterys;
import step2.winning.LotteryMatcher;
import step2.winning.PrizeWinningNumber;
import step2.winning.Winning;
import step2.winning.WinningResults;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMatcherTest {
    @Test
    @DisplayName("당첨 번호와 보너스 볼을 입력받아, 당첨 결과를 반환한다.")
    void matchTest() {
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber("1,2,3,4,5,6", 7);
        Lotterys lotterys = new Lotterys(1, new Generate() {
            @Override
            public Set<LotteryNumber> makeNumbers(int size) {
                return Set.of(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(7));
            }
        });

        WinningResults result = LotteryMatcher.match(prizeWinningNumber, lotterys);
        assertThat(result.getWinningResult(Winning.SECOND)).isEqualTo(1);
    }
}
