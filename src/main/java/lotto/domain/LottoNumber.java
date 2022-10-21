package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.shuffle;

public class LottoNumber {

    private static final Integer LOTTO_NUMBER_MIN_INDEX = 0;
    private static final Integer LOTTO_NUMBER_MAX_INDEX = 6;
    private static final Integer LOTTO_DEFAULT_START_NUMBER = 1;
    private static final Integer LOTTO_DEFAULT_END_NUMBER = 45;

    private LottoNumber() {
        throw new AssertionError();
    }

    public static List<Integer> getAutoNumberList() {
        return makeAutoNumberList(defaultNumberList());
    }

    private static List<Integer> defaultNumberList() {
        List<Integer> defaultNumberList = new ArrayList<>();
        for (int i = LOTTO_DEFAULT_START_NUMBER; i <= LOTTO_DEFAULT_END_NUMBER; i++) {
            defaultNumberList.add(i);
        }
        return defaultNumberList;
    }

    private static List<Integer> makeAutoNumberList(List<Integer> defaultNumberList) {
        shuffle(defaultNumberList);
        List<Integer> lottoNumberList = defaultNumberList.subList(LOTTO_NUMBER_MIN_INDEX, LOTTO_NUMBER_MAX_INDEX);
        lottoNumberList.sort(Comparator.comparing(Integer::intValue));
        return lottoNumberList;
    }

}
