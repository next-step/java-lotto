package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberUtil {
    private static final Integer GET_LIST_START = 0;
    private static final Integer GET_LIST_END = 6;
    private static List<Integer> lottoNums;

    static {
        setDefaultLottoNums();
    }

    static List<Integer> getDefaultLottoNums() {
        return getCopyList();
    }

    private static void setDefaultLottoNums() {
        lottoNums = new ArrayList<>(45);
        for (int i = 0; i < 45; i++) {
            lottoNums.add(i + 1);
        }
    }

    public static List<Integer> getAutoLottoNums() {
        return getSortList(getSubList(getShuffleList(getDefaultLottoNums())));
    }

    static List<Integer> getCopyList() {
        List<Integer> copyLottoNum = new ArrayList<>();
        copyLottoNum.addAll(lottoNums);
        return copyLottoNum;
    }

    static List<Integer> getShuffleList(List<Integer> defaultNums) {
        Collections.shuffle(defaultNums);
        return defaultNums;
    }

    static List<Integer> getSortList(List<Integer> defaultNums) {
        Collections.sort(defaultNums);
        return defaultNums;
    }

    static List<Integer> getSubList(List<Integer> defaultNums) {
        return defaultNums.subList(GET_LIST_START, GET_LIST_END);
    }
}
