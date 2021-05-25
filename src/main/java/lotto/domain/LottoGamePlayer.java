package lotto.domain;

import lotto.common.WinningType;
import lotto.view.ResultView;

public class LottoGamePlayer {
    ResultView resultView = new ResultView();

    public void play(LottoTicket winningLottoTicket, LottoTickets lottoTickets) {
        WinningType[] winningTypes = lottoTickets.getGameResults(winningLottoTicket);
        int[] matchCountResults = getMatchCountResult(winningTypes);
        resultView.printResultStatistics(matchCountResults);
    }

    public int[] getMatchCountResult(WinningType[] winningTypes) {
        int[] matchCountResults = new int[] {0,0,0,0,0,0,0};
        for(int i=0; i<winningTypes.length; i++) {
            matchCountResults[winningTypes[i].getMatchCount()] ++;
        }

        return matchCountResults;
    }
}
