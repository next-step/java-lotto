package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Lotto> lottos;

    public List<Reward> rewards;

    public Game(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void match(PreviousLotto previousLotto) {
        rewards = lottos.stream()
                .map(previousLotto::match)
                .collect(Collectors.toList());
    }

    public int countReward(Reward reward) {
        return (int) rewards.stream()
                .filter(it -> it == reward)
                .count();
    }

    public String getYield() {
        return String.format("%.2f", rewards.stream()
                .mapToLong(Reward::getMoney)
                .sum() / (LottoMachine.LOTTO_PRICE * rewards.size() * 1.0) - 0.005);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
