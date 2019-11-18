package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottosGenerator implements LottosGenerator {
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;
    private Money money;

    public AutoLottosGenerator(Money money) {
        this.money = money;
    }

}
