package lotto_step2.model;

import java.util.*;

import static lotto_step2.LottoConstants.*;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public Lottos(Lotto lotto) {
        this.lottos = new ArrayList<>();
        lottos.add(lotto);
    }

    public Lottos(int money) {
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 0; i < buyLottoCount(money); i++) {
            lottos.add(new Lotto(lottoMachine.createRandomList()));
        }
    }

    public List<PrizeMachine> matches(Lotto lastWeekLotto, int bonusLotto, Lottos myLotto) {
        List<PrizeMachine> prizes = new ArrayList<>();
        for (Lotto lotto : myLotto.getLottos()) {
            prizes.add(lotto.match(lastWeekLotto, bonusLotto));
        }
        return prizes;
    }

    private int buyLottoCount(int money) {
        return money / LOTTO_PER_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
