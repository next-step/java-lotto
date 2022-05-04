package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    public int numberCheck(List<Integer> pickLottoNumberOfWeek) {
        return (int) pickLottoNumberOfWeek
                .stream()
                .filter(pick::contains)
                .count();
    }
}
