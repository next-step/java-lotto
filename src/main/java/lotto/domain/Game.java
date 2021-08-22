package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    private final List<Lotto> lottos;
    private List<Reward> rewards;

    private Game(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Game from(List<Lotto> autoLottos) {
        return new Game(autoLottos);
    }

    public static Game of(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        List<Lotto> lottos = Stream.of(autoLottos, manualLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new Game(lottos);
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
