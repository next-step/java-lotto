package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(int count) {
        this.lottoes = new ArrayList<>();
        purchaseLottoes(count);
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    protected void purchaseLottoes(int count) {
        for (int i = 0; i < count; i++) {
            lottoes.add(new Lotto());
        }
    }
}
