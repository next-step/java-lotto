package step2.domain;

import java.util.*;

public class Lotto {
    private static final int QTY = 6;
    private static final int LOTTO_VALUE = 45;
    private List<Integer> lottos = new ArrayList<>();

    public void addNumber() {
        autoLottoNumber();
        shuffle();
        sort();
    }

    private void autoLottoNumber() {
        Set<Integer> set = new HashSet<>();
        while (QTY > set.size()) {
            set.add((int) (Math.random() * LOTTO_VALUE) + 1);
        }
        this.lottos = new ArrayList<>(set);
    }

    public List<Integer> getLottos() {
        return this.lottos;
    }

    private void shuffle() {
        Collections.shuffle(this.lottos, new Random());
    }

    private void sort() {
        Collections.sort(this.lottos);
    }

}