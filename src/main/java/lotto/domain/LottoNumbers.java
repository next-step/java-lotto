package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {
    public static final String LOTTO_NUMBER_DISTINCT_MESSAGE = "로또 번호는 중복될 수 없습니다.";
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        checkDistinct();
    }

    private void checkDistinct() {
        if (lottoNumbers.size() < LottoGenerator.LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DISTINCT_MESSAGE);
        }
    }

    public int size() {
        return lottoNumbers.size();
    }
}
