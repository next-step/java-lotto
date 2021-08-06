package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Lotties lotties;
    private final int lottoCount;

    public LottoMachine(final int money) {
        if (!validMoney(money)) {
            throw new RuntimeException();
        }
        this.lottoCount = money / 1000;
        this.lotties = new Lotties(createRandomLotties(money));
    }

    private List<Lotto> createRandomLotties(final int money) {
        List<Lotto> lotties = new ArrayList<>();
        for(int i = 0; i < money / 1000; i++) {
            lotties.add(new Lotto(new RandomNumGenerator()));
        }
        return lotties;
    }

    private boolean validMoney(int money) {
        return money % 1000 == 0;
    }

    public Lotties getLotties() {
        return lotties;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int lottiesCount() {
        return lotties.getCount();
    }
}
