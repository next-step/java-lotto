package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.util.RandomNumbersGenerator.generateNumbers;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private final Money money;

    private final Lottos lottos;

    public Wallet(Money money) {
        this.money = money;
        lottos = new Lottos();
    }

    public Wallet(Money money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = new Lottos(lottos);
    }

    public Money money() {
        return money;
    }

    public int lottosCount() {
        return lottos.size();
    }

    public Wallet purchaseLotto() {
        int lottoCount = calculatePurchaseLottoCount();
        List<Lotto> purchaseLottos = new ArrayList<>();
        addNewLotto(lottoCount, purchaseLottos);
        return new Wallet(calculateRemainMoney(lottoCount), purchaseLottos);
    }

    private Money calculateRemainMoney(int lottoCount) {
        return money.useMoney(lottoCount * LOTTO_PRICE);
    }

    private int calculatePurchaseLottoCount() {
        return money.calculatePurchaseCount(LOTTO_PRICE);
    }

    private void addNewLotto(int lottoCount, List<Lotto> purchaseLottos) {
        for (int i=0; i< lottoCount; i++){
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
    }

}
