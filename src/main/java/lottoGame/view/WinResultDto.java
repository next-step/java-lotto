package lottoGame.view;

import static lottoGame.model.winner.WinStandard.FIRST;
import static lottoGame.model.winner.WinStandard.FOURTH;
import static lottoGame.model.winner.WinStandard.SECOND;
import static lottoGame.model.winner.WinStandard.THIRD;

import lottoGame.model.winner.WinStandard;
import lottoGame.model.winner.WinnerResult;

public class WinResultDto {

    private final int fourthCount;
    private final int thirdCount;
    private final int secondCount;
    private final int firstCount;
    private final String rateOfReturn;

    public WinResultDto(WinnerResult winnerResult, int buyPrice) {
        this(
                winnerResult.findWinCount(FOURTH),
                winnerResult.findWinCount(THIRD),
                winnerResult.findWinCount(SECOND),
                winnerResult.findWinCount(FIRST),
                String.valueOf(winnerResult.calculateRateOfReturn(buyPrice))
        );
    }

    public WinResultDto(
            int fourthCount,
            int thirdCount,
            int secondCount,
            int firstCount,
            String rateOfReturn
    ) {
        this.fourthCount = fourthCount;
        this.thirdCount = thirdCount;
        this.secondCount = secondCount;
        this.firstCount = firstCount;
        this.rateOfReturn = rateOfReturn;
    }

    public String toString() {
        return FOURTH.desc() + this.fourthCount + "개\n"
                + THIRD.desc() + this.thirdCount + "개\n"
                + SECOND.desc() + this.secondCount + "개\n"
                + FIRST.desc() + this.firstCount + "개\n"
                + "총 수익률은 " + this.rateOfReturn + "입니다.";
    }
}
