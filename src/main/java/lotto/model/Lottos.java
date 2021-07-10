package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Prizes makePrizes(WinningLotto winningLotto) {
        List<Reward> rewards = lottos.stream()
                .map(lotto -> winningLotto.makeReward(lotto))
                .collect(Collectors.toList());

        return new Prizes(rewards);
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}