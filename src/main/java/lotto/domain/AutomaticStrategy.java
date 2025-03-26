package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutomaticStrategy implements GeneratorStrategy {

    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
    public static final int START_LEN = 0;
    public static final int END_LEN = 6;

    @Override
    public Lotto generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = START_NUM; i <= END_NUM; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumbers);

        return new Lotto(lottoNumbers.subList(START_LEN, END_LEN));
    }
}
