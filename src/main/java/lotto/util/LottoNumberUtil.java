package lotto.util;

import lotto.domain.LottoNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberUtil {
    private static final Integer GET_LIST_START = 0;
    private static final Integer GET_LIST_END = 6;
    private static List<LottoNum> lottoNums;

    private LottoNumberUtil() {
        throw new AssertionError();
    }

    static {
        setDefaultLottoNums();
    }

    private static List<LottoNum> getDefaultLottoNums() {
        return new ArrayList<>(lottoNums);
    }

    private static void setDefaultLottoNums() {
        lottoNums = new ArrayList<>(45);
        for (int i = 0; i < 45; i++) {
            lottoNums.add(new LottoNum(i + 1));
        }
    }

    public static List<LottoNum> getAutoLottoNums() {
        return getSortList(getSubList(getShuffleList(getDefaultLottoNums())));
    }

    private static List<LottoNum> getShuffleList(List<LottoNum> defaultNums) {
        Collections.shuffle(defaultNums);
        return defaultNums;
    }

    private static List<LottoNum> getSortList(List<LottoNum> defaultNums) {
        Collections.sort(defaultNums);
        return defaultNums;
    }

    private static List<LottoNum> getSubList(List<LottoNum> defaultNums) {
        return defaultNums.subList(GET_LIST_START, GET_LIST_END);
    }
}
