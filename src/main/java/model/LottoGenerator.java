package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<Integer> numberSet;
    private final int lottoNumberCount;

    public LottoGenerator(List<Integer> numberSet, int lottoNumberCount) {
        this.numberSet = numberSet;
        this.lottoNumberCount = lottoNumberCount;
    }

    public Lotto randomLotto() {
        List<Integer> copy = new ArrayList<>(List.copyOf(numberSet));
        Collections.shuffle(copy);
        return new Lotto(copy.subList(0, lottoNumberCount));
    }
}
