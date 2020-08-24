package step3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class LottoStat {
    private static final int SCALE = 2;
    private static final int INCREMENT = 1;
    private final HashMap<Rank, Integer> rank;

    public LottoStat() {
        rank = new HashMap<>();
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
        return rank.get(Rank.FIRST) * Rank.FIRST.getWinningMoney() +
                rank.get(Rank.SECOND) * Rank.SECOND.getWinningMoney() +
                rank.get(Rank.THIRD) * Rank.THIRD.getWinningMoney() +
                rank.get(Rank.FOURTH) * Rank.FOURTH.getWinningMoney() +
                rank.get(Rank.FIFTH) * Rank.FIFTH.getWinningMoney();
    }
}
