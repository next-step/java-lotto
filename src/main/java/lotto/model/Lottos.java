package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final List<Lotto> lottoList = new ArrayList<>();

    public Lottos() {

    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void manualLotto(String lotto) {
        lottoList.add(new Lotto(lotto));
    }

    public void autoLotto(Integer numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
    }
}
