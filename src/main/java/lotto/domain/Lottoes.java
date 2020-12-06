package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(final int count) {
        this.lottoes = purchaseLottoes(count);
    }

    public Lottoes(final List<List<Integer>> lottoes) {
        this.lottoes = lottoes.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    private List<Lotto> purchaseLottoes(final int count) {
        final List<Lotto> newLottoes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            newLottoes.add(new Lotto());
        }

        return newLottoes;
    }
}
