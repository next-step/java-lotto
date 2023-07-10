package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {

    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    private static void shuffleLottoNumber() {
        Collections.shuffle(lottoNumbers);
    }

    private static ArrayList<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers.subList(0, 6));
    }

    public Lotto generate() {
        shuffleLottoNumber();
        return new Lotto(getLottoNumbers());
    }
}
