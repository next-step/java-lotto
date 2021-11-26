package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Wallet {
    private Money money;
    private final List<Lotto> lottos;

    /*
        CONSTRUCTOR
     */
    public Wallet(int money) {
        this(new Money(money), new ArrayList<>());
    }

    public Wallet(int money, List<Lotto> lottos) {
        this(new Money(money), lottos);
    }

    public Wallet(Money money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    /*
        INTERFACE
     */
    public void buyLotto(Money unitPrice) {
        final int quotient = this.money.quotient(unitPrice);

        for (int i = 0; i < quotient; i++) {
            this.lottos.add(new Lotto());
            this.money = this.money.subtract(unitPrice);
        }
    }

    public LottoResult lottoResult(WinLotto winLotto) {
        final Map<Prize, Integer> result = new HashMap<>();

        for (Lotto lotto : this.lottos) {
            final Prize prize = Prize.of(lotto.matchCount(winLotto), lotto.bonusContained(winLotto));
            result.putIfAbsent(prize, 0);
            result.put(prize, result.get(prize));
        }

        return new LottoResult(result);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    /*
        FUNCTION
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(money, wallet.money) && lottos.size() == lottos.stream().filter(wallet.lottos::contains).count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottos);
    }
}
