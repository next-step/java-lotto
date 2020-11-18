package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Reward {

    private Map<PrizeInformation, Integer> rewardResult = new EnumMap<>(PrizeInformation.class);
    private List<PrizeInformation> prizeInformations;


    public Reward(List<PrizeInformation> prizeInformations) {
        this.prizeInformations = prizeInformations;
        initiallizeReward();
    }

    private void initiallizeReward() {
        for (PrizeInformation prize : PrizeInformation.values()) {
            rewardResult.put(prize, 0);
        }
    }

    public Map<PrizeInformation, Integer> getRewardResult() {
        prizeInformations.stream()
                .filter(prize -> prize != null)
                .forEach(prize -> rewardResult.put(prize, rewardResult.get(prize) + 1));
        return rewardResult;
    }

    public float earningRate(int purchasePrice) {
        int totalRewardPrice = rewardResult.entrySet().stream()
                .filter(prize -> prize.getValue() > 0)
                .mapToInt(prize -> prize.getKey().getPrizePrice())
                .sum();
        return totalRewardPrice == 0 ? 0 : (float) totalRewardPrice / purchasePrice;

    }
}
