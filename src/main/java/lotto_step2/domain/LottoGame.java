package lotto_step2.domain;

import lotto_step2.model.Lotto;
import lotto_step2.model.Lottos;
import lotto_step2.model.PrizeMachine;

import java.util.List;

public class LottoGame {

    public Lottos getBuyLottos(int money) {
        return new Lottos(money);
    }

    public List<PrizeMachine> matches(Lotto lastWeekLotto, int bonusLotto, Lottos myLottos) {
        Lottos lottos = new Lottos();
        return lottos.matches(lastWeekLotto, bonusLotto, myLottos);
    }
}
