package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<List<Integer>> lottos = new ArrayList<>();

    //로또 추가
    public void addLotto(List<Integer> lotto) {
        this.lottos.add(lotto);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

}
