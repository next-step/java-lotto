package lotto.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.shuffle;

public class LottoNumber {

    protected static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer LOTTO_DEFAULT_START_NUMBER = 1;
    private static final Integer LOTTO_DEFAULT_END_NUMBER = 45;

    public static List<Integer> getLottoNumberList() {
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
        List<Integer> lottoNumberList = defaultNumberList.subList(0, LOTTO_NUMBER_SIZE);
        lottoNumberList.sort(Comparator.comparing(Integer::intValue));
        return lottoNumberList;
    }

}
