package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
