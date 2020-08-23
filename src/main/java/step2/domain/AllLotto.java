package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class AllLotto {

    private static final int LOTTO_START_NUMBER_VALUE = 1;
    private static final int LOTTO_LAST_NUMBER_VALUE = 45;

    public static List<Integer> makeAllLottoNumber() {
        List<Integer> lottoAllNumberList = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER_VALUE; i <= LOTTO_LAST_NUMBER_VALUE; i++) {
            lottoAllNumberList.add(i);
        }
        return lottoAllNumberList;
    }
}
