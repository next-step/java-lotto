package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Lotto> lottoList;

    public User() {
        this.lottoList = new ArrayList<>();
    }


    public void buyLotto(Lotto defaultLotto) {
        lottoList.add(defaultLotto.buyLotto());
    }
}
