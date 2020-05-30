package lotto.domain;

import java.util.*;

public class RandomLottoNumber implements LottoNumber {

    private static final List<Integer> totalNumberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                                                                                , 11, 12, 13, 14, 15, 16, 17, 18, 19
                                                                                , 20, 21, 22, 23, 24, 25, 26, 27, 28, 29
                                                                                , 30, 31, 32, 33, 34, 35, 36, 37, 38, 39
                                                                                , 40, 41, 42, 43, 44, 45));

    private static final int LOTTO_NUMBER = 6;

    @Override
    public List<Integer> generateNumber() {
        Collections.shuffle(totalNumberList);
        return totalNumberList.subList(0, LOTTO_NUMBER);
    }
}
