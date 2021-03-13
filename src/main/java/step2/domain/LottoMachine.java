package step2.domain;

import java.util.*;

public class LottoMachine {

    private Lottos lottos = new Lottos();

    public List<Lotto> createLotto(int money) {
        lottos.createLottoList(money);
        return null;
    }
}
