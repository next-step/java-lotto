package step3.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import step3.model.LottoNumber;
import step3.model.LottoNumbers;
import step3.model.Price;
import step3.model.TotalLotto;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<Integer> lottoRange;

    public Lotto() {
        lottoRange = new ArrayList<>();
        setLootoRange(lottoRange);
    }

    private void setLootoRange(List<Integer> lottoRange) {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            lottoRange.add(number);
        }
    }

    public LottoNumbers pickLottoOne() {
        Collections.shuffle(lottoRange);
        LottoNumbers lottoNumbers = new LottoNumbers();
        for (int index = 0; index < 6; index++) {
            lottoNumbers.addNumber(new LottoNumber(lottoRange.get(index)));
        }
        return lottoNumbers;
    }

    public TotalLotto pickLottoWithPrice(Price price) {
        TotalLotto totalLotto = new TotalLotto();
        int totalCount = price.getBuyCount();
        for (int index = 0; index < totalCount; index++) {
            totalLotto.addLottoOne(pickLottoOne());
        }
        return totalLotto;
    }
}
