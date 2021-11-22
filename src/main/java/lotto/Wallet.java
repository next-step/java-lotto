package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wallet {
    private final int money;
    private final List<Lotto> lottos;

    public Wallet(int money) {
        this(money, 0);
    }

    public Wallet(int money, int lottoCount) {
        this.money = money;
        this.lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public Wallet(int money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public void buyLotto(int unitPrice) {
        final int lottoCount = this.money / unitPrice;

        for (int i = 0; i < lottoCount; i++) {
            this.lottos.add(new Lotto());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return money == wallet.money && lottos.size() == wallet.lottos.size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottos);
    }

    public int lottoResultByPrize(LottoResult lottoResult, Prize targetPrize) {
        return (int) lottos.stream()
                .map(lotto -> Prize.of(lottoResult.matchCount(lotto), lottoResult.hasBonus(lotto)))
                .filter(prize -> prize.equals(targetPrize))
                .count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
