package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Round {
    private final Set<Pick> myPicks = new HashSet<>();
    private LottoReport report;
    private final Set<Integer> winningBalls = new TreeSet<>();

    public Set<Pick> getMyPicks() {
        return myPicks;
    }

    public void addPicks(Collection<Pick> myPicks) {
        this.myPicks.addAll(myPicks);
    }

    public <T> void setWinningBalls(Collection<Integer> winningBalls) {
        this.winningBalls.addAll(winningBalls);
    }

    public Set<Integer> getWinningBalls() {
        return winningBalls;
    }

    public LottoReport generateReport(Cash lottoPrice, Map<Rank, Prize> prizeMap) {
        Cash cost = new Cash(lottoPrice.getAmount() * myPicks.size(), Currency.WON);
        report = new LottoReport(cost);
        myPicks.stream()
                .map(Pick::getRank)
                .filter(Objects::nonNull)
                .map(prizeMap::get)
                .forEach(report::addPrize);

        return report;
    }
}
