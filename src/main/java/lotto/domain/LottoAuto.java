package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAuto {
    private List<Integer> lotto;

    final static int LOTTO_SELECT_NUM = 6;

    public List<Integer> getlotto(){
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(LottoNumberList.LOTTO_NUMBER_LIST);
        for (int i = 0; i < LOTTO_SELECT_NUM; i++) {
            lotto.add(LottoNumberList.LOTTO_NUMBER_LIST.get(i));
        }
        Collections.sort(lotto);

        return lotto = lotto;
    }


}
