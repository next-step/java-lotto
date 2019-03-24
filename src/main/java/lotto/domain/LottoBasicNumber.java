package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBasicNumber {

    public static final List<LottoBall> basicNumbers;

    static {
        basicNumbers = new ArrayList<>();
        for (int i = LottoBall.MIN_LOTTO_NUMBER; i <= LottoBall.MAX_LOTTO_NUMBER; i++) {
            basicNumbers.add(new LottoBall(i));
        }
    }
}
