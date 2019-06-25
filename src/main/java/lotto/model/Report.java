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

    public double getRateOfReturn() {
        return ((double) getTotalProfits() / getBuyingMoney());
    }

    int getTotalProfits() {
        return prizeStatus.keySet().stream().mapToInt(prize -> {
            int prizeMoney = prize.getPrizeMoney();
            int count = prizeStatus.get(prize);
            return prizeMoney * count;
        }).sum();
    }

    int getBuyingMoney() {
        return lottos.getBuyingMoney();
    }
}
