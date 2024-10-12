package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final List<Lotto> lottoes;

    private Buyer(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public static Buyer of(List<Lotto> lottoes) {
        List<Lotto> result = new ArrayList<>();
        for (Lotto lotto : lottoes) {
            result.add(lotto);
        }
        return new Buyer(result);
    }

    public int size() {
        return this.lottoes.size();
    }

    public List<Lotto> value() {
        return this.lottoes;
    }
}
