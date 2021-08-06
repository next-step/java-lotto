package lotto.step2;

import java.util.ArrayList;
import java.util.Collections;

public class LottoMachine {

    private ArrayList<Integer> lottoNumbers;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LAST_COUNT = 6;

    public LottoMachine() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void getLottoNumbers() {
        for (int i=1; i<=LOTTO_LAST_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public void pickLotto() {
        Collections.shuffle(lottoNumbers);
        for (int i=1; i<=LOTTO_LAST_COUNT; i++){

        }
    }
}
