package lotto.domain;

import java.util.*;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final Set<Lotto> lottos;

    public Lottos() {
        this.lottos = new LinkedHashSet<>();
    }

    public Lottos(int paidMoney) {
        this.lottos = new LinkedHashSet<>();

        int count = paidMoney / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            this.lottos.add(Lotto.getNewInstance());
        }
    }

    public Lottos(Set<Lotto> lottos) {
        this.lottos = new LinkedHashSet<>(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public Lottos add(Lotto lotto) {
        this.lottos.add(lotto);

        return this;
    }

    public Lottos addAll(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);

        return this;
    }

    public MatchResult getMatchResult(WinningNumbers winningNumber) {
        MatchResult matchResult = MatchResult.getInstance();

        for (Lotto lotto : lottos) {
            Rank rank = winningNumber.getMatchResult(lotto);

            matchResult.updateResult(rank);
        }

        return matchResult;
    }

    public Set<Lotto> getLottos() {
        return this.lottos;
    }
}
