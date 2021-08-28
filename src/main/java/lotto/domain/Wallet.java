package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.util.RandomNumbersGenerator.generateNumbers;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private final int money;

    private final List<Lotto> lottos;

    public Wallet(int money) {
        this.money = money;
        lottos = new ArrayList<>();
    }

    public Wallet(int money, List<Lotto> lottos) {
        this(money);
        this.lottos.addAll(lottos);
    }

    public int money() {
        return money;
    }

    public int lottosCount() {
        return lottos.size();
    }

    public Wallet purchaseLotto() {
        int lottoCount = calculatePurchaseLottoCount();
        int leftMoney = money - lottoCount * LOTTO_PRICE;
        List<Lotto> purchaseLottos = new ArrayList<>(lottos);
        for (int i=0; i<lottoCount; i++){
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
        return new Wallet(leftMoney, purchaseLottos);
    }

    private int calculatePurchaseLottoCount() {
        return money / LOTTO_PRICE;
    }

}
