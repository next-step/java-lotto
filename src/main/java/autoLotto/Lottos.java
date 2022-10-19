package autoLotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
