package lotto.domain;

import static lotto.util.RandomNumbersGenerator.generateNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int lottoCount = money.calculatePurchaseCount();
        Money useMoney = money.useMoney(lottoCount);

        Lottos purchaseLottos = new Lottos();
        addNewLotto(lottoCount, purchaseLottos);
        return new Wallet(useMoney, purchaseLottos);
    }

    private void addNewLotto(int lottoCount, Lottos purchaseLottos) {
        for (int i = 0; i < lottoCount; i++) {
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
    }

    public Wallet purchaseManualLotto(List<String> buyLottos) {
        int lottoCount = buyLottos.size();
        Money useMoney = money.useMoney(lottoCount);

        List<Lotto> lottos = buyLottos.stream()
            .map(input -> input.split(","))
            .map(LottoNumber::generateNumbers)
            .map(Lotto::new)
            .collect(Collectors.toList());
        return new Wallet(useMoney, new Lottos(lottos));
    }
}
