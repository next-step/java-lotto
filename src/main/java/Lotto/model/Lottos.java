package Lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<List<Integer>> toNumberList() {
        List<List<Integer>> numberList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            numberList.add(lotto.numbers());
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
