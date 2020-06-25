package lotto.model;

import java.util.Collections;

public class LottoNumbers {
    private LottoNumber[] numbers = new LottoNumber[Lotto.LIMIT];

    public LottoNumbers() {
        Lotto lotto = new Lotto();
        Collections.shuffle(lotto.lottoDrawNumbers);

        for(int i = 0; i < Lotto.LIMIT; i++) {
            numbers[i] = new LottoNumber(lotto.lottoDrawNumbers.get(i));
        }
    }

    public LottoNumbers(LottoNumber[] numbers) {
        this.numbers = numbers;
    }

    public LottoNumber[] getNumbers() {
        return numbers;
    }

    public int getLength() {
        return numbers.length;
    }
}
