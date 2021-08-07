package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enumeration.LottoReward;

public class LottoGameWinnerCalculator {

    public LottoGameWinnerResult calculate(List<LottoTicket> playerTickets,
        LottoTicket winnerTicket) {

        LottoGameWinnerResult result = new LottoGameWinnerResult();
        int playerTicketsCount = playerTickets.size();

        for (LottoTicket playerTicket : playerTickets) {
            int matchedCount = checkHowManyMatchedNumbers(winnerTicket, playerTicket);

            LottoReward reward = decideLottoReward(matchedCount);
            updateWinnerResult(result, reward, playerTicketsCount);
        }

        return result;

    }

    private void updateWinnerResult(LottoGameWinnerResult result, LottoReward reward, int playerTicketsCount) {
        result.updateResultInfo(reward, playerTicketsCount);
    }

    private LottoReward decideLottoReward(int matchedCount) {
        return LottoReward.of(matchedCount);
    }


    private int checkHowManyMatchedNumbers(LottoTicket lastWeekWinnerTicket,
        LottoTicket playerTicket) {
        List<LottoNumber> matchedNumbers = lastWeekWinnerTicket.value().stream()
            .filter(playerTicket.value()::contains)
            .collect(Collectors.toList());

        return matchedNumbers.size();
    }
}
