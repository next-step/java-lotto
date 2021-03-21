package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final List<Number> lottoNumber = new ArrayList<Number>() {
        {
            for (int i = 1; i <= 45; ++i) {
                add(new Number(i));
            }
        }
    };

    public static List<Number> generateLotto(int length) {
        Collections.shuffle(lottoNumber);
        List<Number> newLotto = new ArrayList<>();

        for (int i = 0; i < length; ++i) {
            newLotto.add(lottoNumber.get(i));
        }
        return newLotto;
    }
}
