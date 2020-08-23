package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getNumOfLottos() {
        return lottos.size();
    }

    public Lotto getOneLotto(int index) {
        return lottos.get(index);
    }
}
