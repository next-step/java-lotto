package step2.domain;

import step2.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(NumberGenerator numberGenerator, Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseCount = 1;
        while (money.isPossibleBuyLotto(purchaseCount)) {
            lottos.add(Lotto.from(numberGenerator));
            purchaseCount++;
        }
        return new Lottos(lottos);
    }

    public int getPrizeCount(Lotto prizeLotto, Prize prize) {
        return (int) lottos.stream()
                .map(lotto -> lotto.getMatchCount(prizeLotto))
                .filter(matchCount -> matchCount == prize.getMatchCount())
                .count();
    }

    public int getTotalPrizeAmount(Lotto prizeLotto) {
        return lottos.stream()
                .map(lotto -> lotto.getMatchCount(prizeLotto))
                .map(matchCount -> Prize.findPrize(matchCount))
                .map(Prize::getAmount)
                .reduce(0, Integer::sum);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
