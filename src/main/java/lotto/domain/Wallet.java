package lotto.domain;

import static lotto.util.RandomNumbersGenerator.generateNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.StringUtil;

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

    public Wallet purchaseLotto(List<String> buyLottos) {
        List<Lotto> lottos = new ArrayList<>();

        Money moneyByManual = addManualLotto(buyLottos, lottos);
        Money moneyByRandom = addRandomLotto(moneyByManual, lottos);
        return new Wallet(moneyByRandom, new Lottos(lottos));
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
        Money useMoneyRandom = money.useMoney(lottoCount);
        for (int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(generateNumbers()));
        }
        return useMoneyRandom;
    }

}
