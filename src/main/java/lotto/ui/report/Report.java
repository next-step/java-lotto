package lotto.ui.report;

import lotto.core.omr.Omr;
import lotto.core.omr.OmrCard;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.util.RateUtils;
import java.text.DecimalFormat;
import java.util.*;

public class Report {
    private static final DecimalFormat dc = new DecimalFormat("###,###,###,###");

    private final double totalPrice;
    private final double totalWinningMoney;
    private final Map<Rank, List<Omr>> result;

    public Report(OmrCard omrCard, Round round) {
        this.result = omrCard.grade(round);
        this.totalPrice = calcTotalPrice(omrCard);
        this.totalWinningMoney = calcTotalWinningMoney();
    }

    public String getRankFormat(Rank rank) {
        int size = getSize(rank);
        String bonusMessage = getBonusMessage(rank);

        return String.format("%d개 일치%s(%d원)- %d개", rank.countOfMatch(), bonusMessage, rank.winningMoney(), size);
    }

    public double getYields() {
        return RateUtils.getRate(totalPrice, totalWinningMoney);
    }

    public String getTotalPrice() {
        return dc.format(totalPrice);
    }

    public String getTotalWinningMoney() {
        return dc.format(totalWinningMoney);
    }

    private boolean isFiveOfMatch(Rank rank) {
        return rank == Rank.THIRD || rank == Rank.SECOND;
    }

    private int getSize(Rank rank) {
        if (isFiveOfMatch(rank)) {
            Optional<List<Omr>> secondOptional = Optional.ofNullable(result.get(Rank.SECOND));
            Optional<List<Omr>> thirdOptional = Optional.ofNullable(result.get(Rank.THIRD));

            return secondOptional.orElse(Collections.EMPTY_LIST).size() + thirdOptional.orElse(Collections.EMPTY_LIST).size();
        }

        List<Omr> omrs = result.get(rank);
        return (omrs == null) ? 0 : omrs.size();
    }

    private String getBonusMessage(Rank rank) {
        if (isFiveOfMatch(rank)) {
            return ", 보너스 볼 일치";
        }

        return " ";
    }

    private double calcTotalPrice(OmrCard omrCard) {
        return omrCard.size() * OmrCard.PRICE;
    }

    private double calcTotalWinningMoney() {
        return result.keySet().stream()
                    .mapToInt(key->result.get(key).size() * key.winningMoney())
                    .sum();
    }

}
