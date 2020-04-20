package lotto.domain;

import lotto.exception.InvalidInputToGenerateLottos;

import java.util.*;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final Set<Lotto> lottos;

    public Lottos() {
        this.lottos = new LinkedHashSet<>();
    }

    public Lottos(int lottoPrice) {
        this.lottos = new LinkedHashSet<>();

        int count = lottoPrice / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            this.lottos.add(Lotto.getNewInstance());
        }
    }

    private Lottos(int paidMoney, int generatedCount) {
        this(paidMoney - generatedCount * LOTTO_PRICE);
    }

    public Lottos(Set<Lotto> lottos) {
        this.lottos = new LinkedHashSet<>(lottos);
    }


    public static Lottos getAutoLottos(int paidMoney, int generatedCount) {
        if (paidMoney - generatedCount * LOTTO_PRICE < 0) {
            throw new InvalidInputToGenerateLottos();
        }

        return new Lottos(paidMoney, generatedCount);
    }

    public static Lottos getInstance(List<Lotto> lottos) {
        return new Lottos(new HashSet<>(lottos));
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
