package lotto.ui.view;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static lotto.ui.LottoDisplay.NEW_LINE;

public class DisplayLottoList {

    public static final String LOTTO_SET_PREFIX = "[";
    public static final String LOTTO_SET_DELIMITER = ", ";
    public static final String LOTTO_SET_SUFFIX = "]";

    private final List<Set<Integer>> lottoList;

    public DisplayLottoList(List<Set<Integer>> lottoList) {
        this.lottoList = lottoList;
    }

    private String toLottoString(Set<Integer> lottos){
        return lottos.stream()
            .map(l -> String.format("%2d", l))
            .collect(joining(LOTTO_SET_DELIMITER, LOTTO_SET_PREFIX, LOTTO_SET_SUFFIX));
    }

    @Override
    public String toString() {
        return lottoList.stream()
                        .map(this::toLottoString)
                        .collect(joining(NEW_LINE))
            ;
    }
}
