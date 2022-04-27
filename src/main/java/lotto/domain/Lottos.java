package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);
        return new Lottos(lottos);
    }

    public double earningRate(WinningLotto winningLotto) {
        return earnings(winningLotto) / expense();
    }

    private double earnings(WinningLotto winningLotto) {
        return lottos.stream()
                .mapToDouble(lotto -> lotto.earnings(winningLotto))
                .sum();
    }

    private int expense() {
        return lottos.size() * LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
