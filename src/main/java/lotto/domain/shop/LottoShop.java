package lotto.domain.shop;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.RandomLottoGenerator;

public class LottoShop {
    private final LottoMachine lottoMachine;
    private long balance;

    public LottoShop(long balance) {
        this.lottoMachine = new LottoMachine(new RandomLottoGenerator());
        this.balance = balance;
    }

    public LottoShop(long balance, LottoGenerator lottoGenerator) {
        this.lottoMachine = new LottoMachine(lottoGenerator);
        this.balance = balance;
    }

    public List<Lotto> purchase() {
        return null;
    }

}
