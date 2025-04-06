package Lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<List<Integer>> toIntegerNumberList() {
        List<List<Integer>> numberList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> converted = lotto.numbers().stream()
                    .map(LottoNumber::value)
                    .collect(Collectors.toList());
            numberList.add(converted);
        }

        return numberList;
    }

    public List<Lotto> all() {
        return new ArrayList<>(lottos);
    }

    public int size() {
        return lottos.size();
    }

}
