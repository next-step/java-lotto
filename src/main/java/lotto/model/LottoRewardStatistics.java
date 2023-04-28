package lotto.model;

public class LottoRewardStatistics {
    private final LottoPlaceCounter counter;

    public LottoRewardStatistics(LottoPlaceCounter counter) {
        if (counter.total() == 0) {
            throw new IllegalArgumentException("counter is empty");
        }
        this.counter = counter;
    }


    public float profit() {
        long rewards = winnerRewards();
        int spent = counter.total() * Lotto.PRICE;

        return rewards / (float) spent;
    }

    public long winnerRewards() {
        return Place.winners().stream()
                .mapToLong(this::reward)
                .sum();
    }

    public int reward(Place place) {
        return counter.get(place) * place.reward();
    }
}
