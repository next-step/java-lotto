package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Integer> autoLottoNumber() {
        List<Integer> lottoNumbers = createLottoMachine();
        Collections.shuffle(lottoNumbers);
        List<Integer> lottoGameNumbers = lottoNumbers.subList(0,6);
        Collections.sort(lottoGameNumbers);
        return lottoGameNumbers;
    }

    private List<Integer> createLottoMachine() {
        List<Integer> lottoNumbers = new ArrayList <>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}
