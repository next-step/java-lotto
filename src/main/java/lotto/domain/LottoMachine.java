package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    final static int LOTTO_SELECT_NUM = 6;
    public Lotto getAutoLotto() {
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(LottoNumbers.LOTTO_NUMBER_LIST);
        for (int i = 0; i < LOTTO_SELECT_NUM; i++) {
            lotto.add(LottoNumbers.LOTTO_NUMBER_LIST.get(i));
        }

        return new Lotto(lotto);
    }
}
