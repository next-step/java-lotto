package step2.domain;

import java.util.Collections;
import java.util.List;

public class LottoStore {
    private final int PRICE = 1000;

    public int getPurchaseLottoCount(int purchasePrice) {
        return purchasePrice / this.PRICE;
    }

    public List<Integer> getLottoNumbers() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getTotalNumbers();
        Collections.shuffle(lottoNumbers);
        List<Integer> extractionLottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(extractionLottoNumbers);
        return extractionLottoNumbers;
    }
}
