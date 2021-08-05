package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lotties;

    public LottoMachine(final int money) {
        if (!validMoney(money)) {
            throw new RuntimeException();
        }
        this.lotties = createLotto(money);
    }

    private List<Lotto> createLotto(int money) {
        List<Lotto> lotties = new ArrayList<>();
        for(int i = 0; i < money / 1000; i++) {
            lotties.add(new Lotto());
        }
        return lotties;
    }

    private boolean validMoney(int money) {
        return money % 1000 == 0;
    }

    public int lottiesCount() {
        return lotties.size();
    }
}
