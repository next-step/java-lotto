package step2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buy(Money money) {
        List<Lotto> list = new ArrayList<>();
        for(int i = 0; i < getCount(money); i++) {
            list.add(Lotto.buy());
        }
        return list;
    }

    public static int getCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }
}
