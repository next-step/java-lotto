package lotto.domain;

import static lotto.util.RandomNumbersGenerator.generateNumbers;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private static final String UNAVALIABLE_PURCHACE_LOTTO_ERROR_MESSAGE = "로또 게임을 진행하려면 로또 가격보다 많은 돈을 넣어야 한다.";

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

    public Wallet purchaseLotto(List<String> manualLottos) {
        checkAvaliableForPurchaseLotto();
        List<Lotto> lottos = new ArrayList<>();

        Money moneyByManual = addManualLotto(manualLottos, lottos);
        Money moneyByRandom = addRandomLotto(moneyByManual, lottos);
        return new Wallet(moneyByRandom, new Lottos(lottos));
    }

    private void checkAvaliableForPurchaseLotto() {
        if (money.calculatePurchaseCount() == 0) {
            throw new IllegalArgumentException(UNAVALIABLE_PURCHACE_LOTTO_ERROR_MESSAGE);
        }
    }

    private Money addManualLotto(List<String> buyLottos, List<Lotto> lottos) {
        Money moneyByManual = money.useMoney(buyLottos.size());
        for (String buyLotto : buyLottos) {
            lottos.add(new Lotto(buyLotto));
        }
        return moneyByManual;
    }

    private Money addRandomLotto(Money money, List<Lotto> lottos) {
        int lottoCount = money.calculatePurchaseCount();
        Money moneyByRandom = money.useMoney(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return moneyByRandom;
    }

    public int calculateRandomLottoCount(int manualLottoCount) {
        return lottos.size() - manualLottoCount;
    }

}
