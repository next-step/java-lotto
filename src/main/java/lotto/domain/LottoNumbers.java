package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
