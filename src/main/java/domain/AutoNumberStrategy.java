package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumberStrategy implements PickNumberStrategy {

    List<LottoNumber> lottoNumbers = new ArrayList<>();

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    private static final int LOTTO_NUM_COUNT = 6;

    public AutoNumberStrategy() {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> makeLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> autoPickNumber = lottoNumbers.subList(0, LOTTO_NUM_COUNT);
        Collections.sort(autoPickNumber);
        return autoPickNumber;
    }
}
