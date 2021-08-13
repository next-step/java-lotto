package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enumeration.LottoReward;

public class LottoGameWinnerCalculator {

    private final LottoTicket winnerTicket;
    private final LottoNumber bonusBallNumber;

    public LottoGameWinnerCalculator(WinnerNumberInfo winnerNumberInfo) {
        this.winnerTicket = winnerNumberInfo.getWinnerTicket();
        this.bonusBallNumber = winnerNumberInfo.getBonusBallNumber();
    }

    public LottoGameWinnerResult calculate(List<LottoTicket> playerTickets) {

        LottoGameWinnerResult result = new LottoGameWinnerResult();
        int playerTicketsCount = playerTickets.size();

        for (LottoTicket playerTicket : playerTickets) {
            LottoReward reward = decideLottoReward(winnerTicket, playerTicket);
            result.updateResultInfo(reward, playerTicketsCount);
        }

        return result;
    }

    private LottoReward decideLottoReward(LottoTicket winnerTicket, LottoTicket playerTicket) {

        int matchedNumberCount = checkHowManyMatchedNumbers(winnerTicket, playerTicket);
        boolean hasMatchedBonusNumber = checkBonusNumberMatch(playerTicket);

        return LottoReward.of(matchedNumberCount, hasMatchedBonusNumber);
    }

    private boolean checkBonusNumberMatch(LottoTicket playerTicket) {

        return playerTicket.value().contains(bonusBallNumber);
    }

    private int checkHowManyMatchedNumbers(LottoTicket winnerTicket,
        LottoTicket playerTicket) {
        List<LottoNumber> matchedNumbers = winnerTicket.value().stream()
            .filter(playerTicket.value()::contains)
            .collect(Collectors.toList());

        return matchedNumbers.size();
    }
}
