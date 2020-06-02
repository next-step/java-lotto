package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public static Lottos create(int num) {
        Lottos lottos = new Lottos();

        for(int i = 0; i < num; i++) {
            lottos.addLotto(Lotto.generate());
        }

        return lottos;
    }

    private void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
