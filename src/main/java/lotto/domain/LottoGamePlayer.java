package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;
import lotto.view.ResultView;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoGamePlayer {
    ResultView resultView = new ResultView();

    public void play(LottoTicket winningLottoTicket, LottoTickets lottoTickets, int bonusNumber) {
        throwDuplicatedBonusBallException(winningLottoTicket, bonusNumber);
        WinningType[] winningTypes = lottoTickets.getWinningTypes(winningLottoTicket, bonusNumber);
        resultView.printResultStatistics(getGameResult(winningTypes));
    }

    public void throwDuplicatedBonusBallException(LottoTicket winningLottoTicket, int bonusNumber) {
        if ( winningLottoTicket.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    public Map<WinningType, Integer> getGameResult(WinningType[] winningTypes) {
        Map<WinningType, Integer> matchCountResults = initMatchCountResults();
        for ( int i = 0; i < winningTypes.length; i++) {
            matchCountResults.put(winningTypes[i], countResult(matchCountResults, winningTypes[i]));
        }

        return matchCountResults;
    }

    private Map<WinningType, Integer> initMatchCountResults() {
        Map<WinningType, Integer> matchCountResults = new LinkedHashMap<>();
        WinningType[] winningTypes = WinningType.values();
        for (int i = winningTypes.length-1; i >= 0; i--) {
            matchCountResults.put(winningTypes[i], 0);
        }

        return matchCountResults;
    }

    private int countResult(Map<WinningType, Integer> matchCountResults, WinningType winningType) {
        if (matchCountResults.containsKey(winningType)) {
            return matchCountResults.get(winningType) + 1;
        }
        return 1;
    }
}
