package lottoGame.model.winner;

import static lottoGame.model.winner.WinStandard.FIRST;
import static lottoGame.model.winner.WinStandard.FOURTH;
import static lottoGame.model.winner.WinStandard.NOTHING;
import static lottoGame.model.winner.WinStandard.SECOND;
import static lottoGame.model.winner.WinStandard.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerResultTest {

    @Test
    void 당첨결과에서_각등수가_몇개_당첨됐는지_확인할_수_있다() {
        WinnerResult winnerResult = new WinnerResult(
                List.of(
                        WinStandard.FIRST,
                        WinStandard.SECOND,
                        WinStandard.THIRD,
                        WinStandard.FOURTH
                )
        );

        assertThat(winnerResult.findWinCount(FIRST)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(SECOND)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(THIRD)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FOURTH)).isEqualTo(1);
    }

    @Test
    void 당첨결과에_미당첨은_추가하지_않을_수_있다() {
        WinnerResult winnerResult = new WinnerResult();

        winnerResult.addWinResult(NOTHING);

        assertThat(winnerResult.findWinCount(NOTHING)).isEqualTo(0);
    }

    @Test
    void 당첨결과에따른_수익률을_계산_할_수_있다() {
        assertThat(
                new WinnerResult(List.of(WinStandard.FOURTH))
                        .calculateRateOfReturn(14000)
        ).isEqualTo(0.35);
    }
}