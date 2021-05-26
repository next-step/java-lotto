package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;
import lotto.view.ResultView;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoGamePlayer {
    ResultView resultView = new ResultView();
    private static final int MATCH_COUNT_RESULT_INIT_NUMBER = 0;
    private static final int MATCH_COUNT_RESULT_PLUS_NUMBER = 1;

    public void play(LottoTicket winningLottoTicket, LottoTickets lottoTickets, int bonusNumber) {
        throwDuplicatedBonusBallException(winningLottoTicket, bonusNumber);
        WinningType[] winningTypes = lottoTickets.getWinningTypes(winningLottoTicket, bonusNumber);
        resultView.printResultStatistics(getGameResult(winningTypes));
    }

    private void throwDuplicatedBonusBallException(LottoTicket winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    public Map<WinningType, Integer> getGameResult(WinningType[] winningTypes) {
        Map<WinningType, Integer> matchCountResults = initMatchCountResults();
        for (int i = 0; i < winningTypes.length; i++) {
            matchCountResults.put(winningTypes[i], countResult(matchCountResults, winningTypes[i]));
        }

        return matchCountResults;
    }

    private Map<WinningType, Integer> initMatchCountResults() {
        Map<WinningType, Integer> matchCountResults = new LinkedHashMap<>();
        WinningType[] winningTypes = WinningType.values();
        for (int i = winningTypes.length-1; i >= 0; i--) {
            matchCountResults.put(winningTypes[i], MATCH_COUNT_RESULT_INIT_NUMBER);
        }

        return matchCountResults;
    }

    private int countResult(Map<WinningType, Integer> matchCountResults, WinningType winningType) {
        if (matchCountResults.containsKey(winningType)) {
            return matchCountResults.get(winningType) + MATCH_COUNT_RESULT_PLUS_NUMBER;
        }
        return MATCH_COUNT_RESULT_PLUS_NUMBER;
    }
}
