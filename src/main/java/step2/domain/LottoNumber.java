package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    List<Integer> lottoNumbers = new ArrayList<Integer>();

    public LottoNumber() {
        initLottoNumbers();
    }

    private void initLottoNumbers() {
        for(int i = 0; i < LOTTO_END_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public void creatLottoNumber() {
        Collections.shuffle(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
