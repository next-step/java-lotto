package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    final static int LOTTO_SELECT_NUM = 6;

    public List<Integer> getLotto(){
        return this.lotto;
    }

    public List<Integer> getAutoLotto(){
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(LottoNumbers.LOTTO_NUMBER_LIST);
        for (int i = 0; i < LOTTO_SELECT_NUM; i++) {
            lotto.add(LottoNumbers.LOTTO_NUMBER_LIST.get(i));
        }
        Collections.sort(lotto);

        return this.lotto = lotto;
    }


}
