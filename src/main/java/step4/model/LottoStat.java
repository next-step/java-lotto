package step4.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStat {
    private static final int SCALE = 2;
    private static final int INCREMENT = 1;
    private final Map<Rank, Integer> rank = new HashMap<>();

    public LottoStat() {
        initializeRank();
    }

    private void initializeRank() {
        for (Rank r1 : Rank.values()) {
            rank.putIfAbsent(r1, 0);
        }
    }

    public void enterLottoTicketScore(List<LottoTicket> ticketList, String[] winningTicket, int bonusBallNumber) {
        for (LottoTicket value : ticketList) {
            rank.put(Rank.valueOf(value.matchedNumber(winningTicket)
                    , value.isBonusBallIncluded(bonusBallNumber)
                    ), rank.get(Rank.valueOf(value.matchedNumber(winningTicket)
                    , value.isBonusBallIncluded(bonusBallNumber)
                    )) + INCREMENT
            );
        }
    }

    public int getNumberOfGrade(Rank value) {
        return rank.get(value);
    }

    public BigDecimal getBenefitRatioFromLottoTicket(int initialInvestAmount) {
        return BigDecimal
                .valueOf(getWinnerPrizeAmount())
                .divide(BigDecimal.valueOf(initialInvestAmount), SCALE, RoundingMode.HALF_UP);
    }

    private long getWinnerPrizeAmount() {
        long prizeAmount = 0;
        for (Rank r1 : Rank.values()) {
            prizeAmount += rank.get(r1) * r1.getWinningMoney();
        }
        return prizeAmount;
    }
}
