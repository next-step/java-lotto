package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.util.RandomNumbersGenerator.generateNumbers;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private final int money;

    private final Lottos lottos;

    public Wallet(int money) {
        this.money = money;
        lottos = new Lottos();
    }

    public Wallet(int money, List<Lotto> lottos) {
        this(money);
        this.lottos.addLottos(lottos);
    }

    public int money() {
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

    private int calculateRemainMoney(int lottoCount) {
        return money - lottoCount * LOTTO_PRICE;
    }

    private int calculatePurchaseLottoCount() {
        return money / LOTTO_PRICE;
    }

    private void addNewLotto(int lottoCount, List<Lotto> purchaseLottos) {
        for (int i=0; i< lottoCount; i++){
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
    }

}
