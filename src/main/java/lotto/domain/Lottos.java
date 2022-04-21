package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public double earningRate(Lotto winningLotto, int bonusNumber) {
        return earnings(winningLotto, bonusNumber) / expense();
    }

    private double earnings(Lotto winningLotto, int bonusNumber) {
        return lottos.stream()
                .mapToDouble(lotto -> lotto.earnings(winningLotto, bonusNumber))
                .sum();
    }

    private int expense() {
        return lottos.size() * LOTTO_PRICE;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
