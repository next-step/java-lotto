package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> pick = new ArrayList<>();

    public Lotto(LottoPickStrategy lottoPickStrategy) {
        pick.addAll(lottoPickStrategy.numberPick());
    }

    public List<LottoNumber> pick() {
        Collections.sort(pick);
        return pick;
    }

    public Rank matching(List<Integer> pickLottoNumberOfWeek, int bonusBall) {
        int count = (int) pickLottoNumberOfWeek
                .stream()
                .filter(pick::contains)
                .count();

        return Rank.of(count, pick.contains(bonusBall));
    }

}
