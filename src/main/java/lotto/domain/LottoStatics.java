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

    public int findRank(WinNumber winNumber, Rank rank, LottoNumber bonus) {
        int result = 0;
        for (Lotto lotto : lottos) {
            result = rank.isMatch(lotto.match(winNumber, bonus)) ? result + 1 : result;
        }

        return result;
    }

    public long totalPrize(WinNumber winNumber, LottoNumber bonus) {
        return Rank.calculatePrize(lottos, winNumber, bonus);
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
