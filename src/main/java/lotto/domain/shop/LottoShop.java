package lotto.domain.shop;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.RandomLottoGenerator;

public class LottoShop {
    private final static long LOTTO_PRICE = 1000;

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
        List<Lotto> lottories = new ArrayList<>();

        while(isEnoughToPurchase()) {
            lottories.add(lottoMachine.generate());
        }
        return lottories;
    }

    private boolean isEnoughToPurchase() {
        if (LOTTO_PRICE > balance) {
            return false;
        }
        balance = balance - LOTTO_PRICE;
        return true;
    }
}
