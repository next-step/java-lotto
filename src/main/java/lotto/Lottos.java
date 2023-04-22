package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final int LOTTO_AMOUNT = 1_000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static List<Lotto> lottoList(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.purchase());
        }
        return lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return new ArrayList<>(lottos);
    }

}
