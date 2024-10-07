package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Set<Integer>> lottos = new ArrayList<>();

    //로또 추가
    public void addLotto(Set<Integer> lotto) {
        this.lottos.add(lotto);
    }

    public List<Set<Integer>> getLottos() {
        return lottos;
    }

}
