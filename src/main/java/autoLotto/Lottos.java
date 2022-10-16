package autoLotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public Lotto getLotto(int i) {
        return lottos.get(i);
    }
}
