package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        this.lottoNumbers = generateLottoNumbers();
    }

    private List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> temp = new ArrayList<>();

        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            temp.add(new LottoNumber(i));
        }
        return temp;
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
