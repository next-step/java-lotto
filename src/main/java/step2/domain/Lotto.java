package step2.domain;

import step2.domain.strategy.LottoPickStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> pick = new ArrayList<>();

    public Lotto(LottoPickStrategy lottoPickStrategy) {
        pick.addAll(lottoPickStrategy.numberPick());
    }

    public List<LottoNumber> pick() {
        Collections.sort(pick);
        return pick;
    }

    public Rank matching(LottoWeeklyNumber lottoWeeklyNumber) {
        return Rank.of(lottoWeeklyNumber.matchCount(pick),
                lottoWeeklyNumber.matchBonus());
    }

}
