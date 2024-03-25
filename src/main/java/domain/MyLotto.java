package domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private static final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

}
