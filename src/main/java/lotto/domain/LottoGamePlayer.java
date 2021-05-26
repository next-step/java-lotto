package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.*;

public class LottoGamePlayer {

    public Map<WinningType, Integer> getGameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, int bonusNumber) {
        throwDuplicatedBonusBallException(winningLottoTicket, bonusNumber);
        List<WinningType> winningResult = userLottoTickets.getWinningResults(winningLottoTicket, bonusNumber);
        Map<WinningType, Integer> matchCountResults = new LinkedHashMap<>();
        Arrays.stream(WinningType.values())
                .forEachOrdered(v -> matchCountResults.put(v, (int) winningResult.stream()
                                                                        .filter(w -> w.equals(v))
                                                                        .count()));
        return matchCountResults;
    }

    private void throwDuplicatedBonusBallException(LottoTicket winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }
}
