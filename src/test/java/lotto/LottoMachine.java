package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lotties;

    public LottoMachine(int money) {
        validMoney(money);
        this.lotties = createLotto(money);
    }

    private List<Lotto> createLotto(int money) {
        List<Lotto> lotties = new ArrayList<>();
        for(int i = 0; i < money / 1000; i++) {
            lotties.add(new Lotto());
        }
        return lotties;
    }

    private void validMoney(int money) {
        if (money % 1000 != 0) {
            throw new RuntimeException("1000원 단위로 구입하세요");
        }
    }

    public int lottiesCount() {
        return lotties.size();
    }
}
