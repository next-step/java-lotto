package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    List <Integer> lottoNumbers;

    public LottoMachine() {
        createLottoMachine();
    }

    private void createLottoMachine() {
        this.lottoNumbers = new ArrayList <>();
        for (int i = 1; i <= 45; i++) {
            this.lottoNumbers.add(i);
        }
    }

    public List<Integer> getGameNumber() {
        Collections.shuffle(this.lottoNumbers);
        return this.lottoNumbers.subList(0,6);
    }
}
