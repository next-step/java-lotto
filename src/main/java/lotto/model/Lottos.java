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

    public Prizes makeRewards(WinningLotto winningLotto) {
        List<Reward> prizes = lottos.stream()
                .map(lotto -> winningLotto.makeReward(lotto))
                .collect(Collectors.toList());

        return new Prizes(prizes);
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