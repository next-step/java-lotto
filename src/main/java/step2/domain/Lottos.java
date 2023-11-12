package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos{

    private List<Lotto> list;

    public Lottos() {
        list = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        list.add(lotto);
    }

    public void removeLotto(Lotto lotto) {
        list.remove(lotto);
    }

    public List<Lotto> getLottos() {
        return list;
    }

    public int getLottoCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}
