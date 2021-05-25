package lotto.domain;

import lotto.common.WinningType;
import lotto.view.ResultView;

public class LottoGamePlayer {
    ResultView resultView = new ResultView();

    public void play(LottoTicket winningLottoTicket, LottoTickets lottoTickets) {
        WinningType[] winningTypes = lottoTickets.getGameResults(winningLottoTicket);
        int[] matchCountResults = getMatchCountResult(winningTypes);
        System.out.println("\n당첨 통계\n---------");
        for(int i=3; i<matchCountResults.length; i++) {
            resultView.printResultStatistics(i, matchCountResults[i]);
        }
    }

    public int[] getMatchCountResult(WinningType[] winningTypes) {
        int[] matchCountResults = new int[] {0,0,0,0,0,0,0};
        for(int i=0; i<winningTypes.length; i++) {
            matchCountResults[winningTypes[i].getMatchCount()] ++;
        }

        return matchCountResults;
    }
}
