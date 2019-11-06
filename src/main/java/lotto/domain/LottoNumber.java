package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;

    private List<Integer> lottoNumbers;

    public LottoNumber() {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers = createLottoNumber();
    }

    public LottoNumber(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers = createLottoNumberWithParameter(() -> lottoNumbers);
    }

    public List<Integer> createLottoNumber() {
        CreatableLotto creatableLotto = new LottoFactory().getLottoVersionSix();
        List<Integer> allLottoNumber = creatableLotto.makeLotto();

        Collections.shuffle(allLottoNumber);
        for (int i = ZERO; i < LOTTO_GET_NUMBER; i++) {
            lottoNumbers.add(allLottoNumber.get(i));
        }
        return lottoNumbers;
    }

    public List<Integer> createLottoNumberWithParameter(CreatableLotto creatableLotto) {
        return creatableLotto.makeLotto();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
