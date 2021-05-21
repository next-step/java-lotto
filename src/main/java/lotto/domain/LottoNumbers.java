package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {
    public static final String LOTTO_NUMBER_SIZE_MESSAGE = "로또 번호는 중복되지 않은 숫자로 최소 6개를 가지고 있어야 합니다.";
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        checkDistinct();
    }

    private void checkDistinct() {
        if (lottoNumbers.size() < LottoGenerator.LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    public int size() {
        return lottoNumbers.size();
    }
}
