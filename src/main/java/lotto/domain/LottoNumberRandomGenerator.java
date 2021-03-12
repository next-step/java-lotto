package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRandomGenerator {

    private static final List<LotteryNumber> allNumbers;

    static {
        List<LotteryNumber> allLottoNumberList = new ArrayList<>();
        for (int i = LotteryNumber.MIN_VALUE; i <= LotteryNumber.MAX_VALUE; i++) {
            allLottoNumberList.add(LotteryNumber.valueOf(i));
        }
        allNumbers = allLottoNumberList;
    }

    public static LotteryNumber generate() {
        Collections.shuffle(allNumbers);
        return allNumbers.get(0);
    }

}
