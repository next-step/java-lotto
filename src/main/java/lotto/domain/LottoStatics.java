package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoStatics {

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoStatics() {
    }

    public LottoStatics(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int matchCount(List<Integer> winnerNumber, Rank rank) {
        int result = 0;
        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winnerNumber);
            result = rank.isMatch(matchCount) ? result + 1 : result;
        }

        return result;
    }

    public long totalPrize(List<Integer> winnerNumber) {
        long totalPrize = 0;

        totalPrize += Rank.calculatePrize(matchCount(winnerNumber, Rank.THREE), Rank.THREE);
        totalPrize += Rank.calculatePrize(matchCount(winnerNumber, Rank.FOUR), Rank.FOUR);
        totalPrize += Rank.calculatePrize(matchCount(winnerNumber, Rank.FIVE), Rank.FIVE);
        totalPrize += Rank.calculatePrize(matchCount(winnerNumber, Rank.WIN), Rank.WIN);

        return totalPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoStatics))
            return false;
        LottoStatics that = (LottoStatics)o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }
}
