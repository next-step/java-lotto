package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int price = 1000;
    private final List<Integer> pick = new ArrayList<>();

    public Lotto(LottoPickStrategy lottoPickStrategy) {
        pick.addAll(lottoPickStrategy.numberPick());
    }

    public List<Integer> pick() {
        Collections.sort(pick);
        return pick;
    }

    public int matching(List<Integer> pickLottoNumberOfWeek) {
        return (int) pickLottoNumberOfWeek
                .stream()
                .filter(pick::contains)
                .count();
    }
}
