package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();
    public Lottos(Integer numberOfLotto) {
        for (int i=0; i<numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
