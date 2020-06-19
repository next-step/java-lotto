package lotto.model;

import java.util.Collections;

public class LottoNumber {
    private int number;

    public LottoNumber() {
        Lotto lotto = new Lotto();
        Collections.shuffle(lotto.lottoDrawNumbers);
        number = lotto.lottoDrawNumbers.get(0);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
