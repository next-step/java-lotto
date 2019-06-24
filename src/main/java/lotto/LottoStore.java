package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStore {

    public static List<LottoNumbers> buy(int money) {
        List<LottoNumbers> list = new ArrayList<>();
        int count = moneyCalculate(money);
        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
            list.add(lottoNumbers);
        }
        return list;
    }

    public static int moneyCalculate(int money) {
        int count = money / 1000;
        if (count < 1) {
            throw new IllegalArgumentException("이걸론 한장도 못사");
        }
        return count;
    }


}
