package lotto.model;

import java.util.Map;

public class Report {

    private final Map<Prize, Integer> prizeStatus;
    private Lottos lottos;

    public Report(Map<Prize, Integer> prizeStatus, Lottos lottos) {
        this.prizeStatus = prizeStatus;
        this.lottos = lottos;
    }

    public Map<Prize, Integer> getPrizeStatus() {
        return prizeStatus;
    }

    public double rateOfReturn() {
        return totalProfits() / buyingMoney();
    }

    public double totalProfits() {
        return prizeStatus.keySet().stream().mapToDouble(prize -> {
            int prizeMoney = prize.getPrizeMoney();
            int count = prizeStatus.get(prize);
            return prizeMoney * count;
        }).sum();
    }

    public double buyingMoney() {
        return lottos.getBuyingMoney();
    }
}
