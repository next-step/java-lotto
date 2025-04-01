package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AutomaticStrategy implements GeneratorStrategy {

    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int START_LEN = 0;
    private static final int END_LEN = 6;

    @Override
    public Lotto generate() {
        List<LottoNo> lottoNos = new ArrayList<>();
        for (int i = START_NUM; i <= END_NUM; i++) {
            lottoNos.add(new LottoNo(i));
        }
        Collections.shuffle(lottoNos);

        return new Lotto(new HashSet<>(lottoNos.subList(START_LEN, END_LEN)));
    }
}
