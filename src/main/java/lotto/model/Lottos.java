package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void manualLotto(String lotto) {
        this.lottoList.add(new Lotto(lotto));
    }

    public void autoLotto(Integer numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            this.lottoList.add(lotto);
        }
    }
}
