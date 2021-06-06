package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public Lotto getAutoLotto() {
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(LottoNumbers.lottoNumberList);
        for (int i = 0; i < LottoConstants.LOTTO_SELECT_NUM; i++) {
            lotto.add(LottoNumbers.lottoNumberList.get(i));
        }
        return new Lotto(lotto);
    }
}
