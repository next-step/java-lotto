package lotto.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public int getBuyingMoney() {
        return Lotto.PRICE * this.lottos.size();
    }

    public List<Prize> matches(WinningLotto winningLotto) {
        return this.lottos.stream().map(winningLotto::matches).collect(toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
