package lotto_step2.model;

import java.util.*;
import static lotto_step2.LottoConstants.*;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(Lotto lotto){
        this.lottos = new ArrayList<>();
        lottos.add(lotto);
    }

    public Lottos(int money) {
        this.lottos = new ArrayList<>();
        for (int i=0; i < buyLottoCount(money); i++) {
            lottos.add(new Lotto(createRandomList()));
        }
    }

    public static List<Prize> matches(Lotto lastWeekLotto, Lottos myLotto) {
        List<Prize> prizes = new ArrayList<>();
        for(Lotto lotto : myLotto.getLottos()) {
            prizes.add(lotto.match(lastWeekLotto));
        }
        return prizes;
    }

    private List<Integer> createRandomList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != LOTTO_LIMIT_SIZE) {
            set.add(getRandom());
        }

        List<Integer> createdLottos = new ArrayList<>(set);
        return createdLottos;
    }

    private int getRandom() {
        return new Random().nextInt(LOTTO_LIMIT_NUMBER) +1;
    }

    private int buyLottoCount(int money) {
        return money / LOTTO_PER_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
