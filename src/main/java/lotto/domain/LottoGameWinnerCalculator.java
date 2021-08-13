package lotto.domain;

import java.util.List;
import lotto.enumeration.LottoReward;

public class LottoGameWinnerCalculator {

    public static LottoGameWinnerResult calculate(WinnerLottoInfo winnerLottoInfo,
        List<LottoTicket> playerTickets) {

        LottoGameWinnerResult result = new LottoGameWinnerResult();
        int playerTicketsCount = playerTickets.size();

        for (LottoTicket playerTicket : playerTickets) {
            LottoReward reward = decideLottoReward(winnerLottoInfo, playerTicket);
            result.updateResultInfo(reward, playerTicketsCount);
        }

        return result;
    }

    private static LottoReward decideLottoReward(WinnerLottoInfo winnerLottoInfo,
        LottoTicket playerTicket) {
        LottoTicket winnerTicket = winnerLottoInfo.getWinnerTicket();
        LottoNumber bonusBallNumber = winnerLottoInfo.getBonusBallNumber();

        int matchedNumberCount = playerTicket.checkHowManyMatchedNumbers(winnerTicket);
        boolean hasMatchedBonusNumber = playerTicket.checkBonusNumberMatch(bonusBallNumber);

        return LottoReward.of(matchedNumberCount, hasMatchedBonusNumber);
    }

}
