package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(int count) {
        this.lottoes = new ArrayList<>();
        purchaseLottoes(count);
    }

    public Lottoes(List<List<Integer>> lottoes) {
        this.lottoes = lottoes.stream().map(Lotto::new).collect(Collectors.toList());
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
