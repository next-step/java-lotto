package lottogame.model.winner;

import static lottogame.model.winner.Rank.FIFTH;
import static lottogame.model.winner.Rank.FIRST;
import static lottogame.model.winner.Rank.FOURTH;
import static lottogame.model.winner.Rank.NOTHING;
import static lottogame.model.winner.Rank.SECOND;
import static lottogame.model.winner.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerResultTest {

    @Test
    void 당첨결과에서_각등수가_몇개_당첨됐는지_확인할_수_있다() {
        WinnerResult winnerResult = new WinnerResult();
        List.of(FIRST, THIRD, FOURTH, FIFTH).forEach(winnerResult::addWinResult);

        assertThat(winnerResult.findWinCount(FIRST)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(THIRD)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FOURTH)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FIFTH)).isEqualTo(1);
    }

    @Test
    void 당첨결과에_미당첨은_추가하지_않을_수_있다() {
        WinnerResult winnerResult = new WinnerResult();

        winnerResult.addWinResult(NOTHING);

        assertThat(winnerResult.findWinCount(NOTHING)).isEqualTo(0);
    }

    @Test
    void 당첨결과에따른_총상금을_계산_할_수_있다() {
        WinnerResult winnerResult = new WinnerResult();
        winnerResult.addWinResult(FIRST);
        winnerResult.addWinResult(SECOND);

        assertThat(
                winnerResult.sumTotalWinReturn()
        ).isEqualTo(2_000_000_000 + 30_000_000);
    }
}