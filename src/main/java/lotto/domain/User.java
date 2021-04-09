package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Lotto> lottoList;

    public User() {
        this.lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void buyLotto(int count) {
        Lotto defaultLotto = new Lotto();
        for (int i = 0; i < count; i++) {
            addLotto(defaultLotto);
        }
    }

    public void addLotto(Lotto defaultLotto) {
        lottoList.add(defaultLotto.buyLotto());
    }

}
