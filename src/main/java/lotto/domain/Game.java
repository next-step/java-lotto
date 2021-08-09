package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Lotto> lottos;

    public Game(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void createRewards(Lotto previousLotto, Ball bonusBall) {
        Reward.rewards = lottos.stream()
                .map(lotto -> {
                    int sameNumberCount = lotto.getSameNumberCount(previousLotto);
                    boolean containBonusBall = lotto.containBonusBall(bonusBall);
                    return Reward.valueOf(sameNumberCount, containBonusBall);
                })
                .collect(Collectors.toList());
    }

    public int countReward(Reward reward) {
        return (int) Reward.rewards.stream()
                .filter(it -> it == reward)
                .count();
    }

    public String getYield() {
        return String.format("%.2f", Reward.rewards.stream()
                .mapToLong(Reward::getMoney)
                .sum() / (LottoMachine.LOTTO_PRICE * Reward.rewards.size() * 1.0) - 0.005);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
