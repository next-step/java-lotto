package lotto.domain;

import java.util.Collections;
import java.util.Random;

public class Shuffle {
    private WholeLottoNumbers wholeLottoNumbers;

    public Shuffle(WholeLottoNumbers wholeLottoNumbers) {
        this.wholeLottoNumbers = wholeLottoNumbers;
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(this.wholeLottoNumbers.lottoNumberList(), new Random(seed));
    }

    public LottoNumber extractLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(this.wholeLottoNumbers.lottoNumberList().subList(0, 6));
        Collections.sort(lottoNumber.numbers());
        return lottoNumber;
    }
}
