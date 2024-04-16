package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int autoLottosSize) {
        this(autoLottosSize, new Lottos(new ArrayList<>()));
    }

    public Lottos(int size, Lottos manualLottos) {
        lottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(new NumbersGenerator()));
        }

        lottos.addAll(manualLottos.of());
    }

    public Lottos(List<Lotto> lottosList) {
        lottos = lottosList;
    }

    public List<Lotto> of() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

}
