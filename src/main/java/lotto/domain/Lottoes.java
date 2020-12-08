package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(final int count) {
        this.lottoes = purchaseLottoes(count);
    }

    public Lottoes(final List<Lotto> lottoes) {
        this.lottoes = Collections.unmodifiableList(lottoes);
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    private List<Lotto> purchaseLottoes(final int count) {
        final List<Lotto> newLottoes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            newLottoes.add(new Lotto());
        }

        return Collections.unmodifiableList(newLottoes);
    }
}
