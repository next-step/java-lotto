package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    public Lotto getAutoLotto() {
        Collections.shuffle(LottoNumbers.lotto_number_list);
        List<Integer> lotto = LottoNumbers.lotto_number_list.stream()
                .limit(LottoConstants.LOTTO_SELECT_NUM)
                .collect(Collectors.toList());
        return new Lotto(lotto);
    }

   public Lotto getManualLotto(String manualLottoStr){
        return new Lotto(manualLottoStr);
   }
}
