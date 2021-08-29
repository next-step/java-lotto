package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.util.RandomNumbersGenerator.generateNumbers;

public class Wallet {

    private final Money money;

    private final Lottos lottos;

    public Wallet(Money money) {
        this.money = money;
        lottos = new Lottos();
    }

    public Wallet(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public Money money() {
        return money;
    }

    public Lottos lottos() {
        return lottos;
    }

    public int lottosCount() {
        return lottos.size();
    }

    public Wallet purchaseLotto() {
        int lottoCount = calculatePurchaseLottoCount();
        Lottos purchaseLottos = new Lottos();
        addNewLotto(lottoCount, purchaseLottos);
        return new Wallet(calculateRemainMoney(lottoCount), purchaseLottos);
    }

    private Money calculateRemainMoney(int lottoCount) {
        return money.useMoney(lottoCount * LOTTO_PRICE);
    }

    private int calculatePurchaseLottoCount() {
        return money.calculatePurchaseCount(LOTTO_PRICE);
    }

    private void addNewLotto(int lottoCount, Lottos purchaseLottos) {
        for (int i=0; i< lottoCount; i++){
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
    }

}
