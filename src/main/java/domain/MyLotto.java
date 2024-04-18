package domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private final static List<Lotto> lottos = new ArrayList<>();

    public static void add(List<LottoBall> nowLotto) {
        lottos.add(new Lotto(nowLotto));
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}

