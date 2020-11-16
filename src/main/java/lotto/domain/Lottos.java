package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {

    private static final int THREE_MATCH_PRIZE_PRICE = 5000;
    private static final int FOUR_MATCH_PRIZE_PRICE = 50000;
    private static final int FIVE_MATCH_PRIZE_PRICE = 150000;
    private static final int ALL_MATCH_PRIZE_PRICE = 2000000000;

    private List<Lotto> lottos;
    private Map<PrizeStatus, Integer> prizeStatus = new HashMap<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<PrizeStatus, Integer> matchPrizeNumber(List<Integer> prizeNumber) {
        IntStream.range(0, lottos.size())
                .forEach(i -> {
                    PrizeStatus status = lottos.get(i).matchPrizeNumber(prizeNumber);
                    if (prizeStatus.containsKey(status)) {
                        prizeStatus.put(status, prizeStatus.get(status) + 1);
                    } else {
                        prizeStatus.put(status, 1);
                    }
                });

        return prizeStatus;
    }

    public int hasLottoSize() {
        return lottos.size();
    }

    public List<Integer> getLottoNumber(int index) {
        return lottos.get(index).getLottoPickNumber();
    }

    public double earningRate(int purchasePrice) {
        double sum = 0;
        for (Map.Entry<PrizeStatus, Integer> entry : prizeStatus.entrySet()) {
            if (entry.getKey().getPrizeNumberCount() == 3) {
                sum += entry.getValue() * THREE_MATCH_PRIZE_PRICE;
            } else if (entry.getKey().getPrizeNumberCount() == 4) {
                sum += entry.getValue() * FOUR_MATCH_PRIZE_PRICE;
            } else if (entry.getKey().getPrizeNumberCount() == 5) {
                sum += entry.getValue() * FIVE_MATCH_PRIZE_PRICE;
            } else if (entry.getKey().getPrizeNumberCount() == 6) {
                sum += entry.getValue() * ALL_MATCH_PRIZE_PRICE;
            }
        }
        return sum / purchasePrice;
    }
}
