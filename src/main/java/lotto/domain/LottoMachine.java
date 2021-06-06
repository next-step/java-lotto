package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public Lotto getAutoLotto() {
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(LottoNumbers.lotto_number_list);
        for (int i = 0; i < LottoConstants.LOTTO_SELECT_NUM; i++) {
            lotto.add(LottoNumbers.lotto_number_list.get(i));
        }
        return new Lotto(lotto);
    }

   public Lotto getManualLotto(String manualLottoStr){
        return new Lotto(manualLottoStr);
   }
}
