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

    public int money() {
        return money;
    }

    public List<Lotto> purchaseLotto() {
        int lottoCount = calculatePurchaseLottoCount();
        List<Lotto> purchaseLottos = new ArrayList<>(lottos);
        for (int i=0; i<lottoCount; i++){
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
        return purchaseLottos;
    }

    private int calculatePurchaseLottoCount() {
        return money / LOTTO_PRICE;
    }

}
