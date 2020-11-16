package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private static final String OVER_SIZE_NUMBERS = "오류:: 로또번호 6개를 초과하여 뽑았습니다";
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static void throwIllegalArgumentException(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() > 6) {
            throw new IllegalArgumentException(OVER_SIZE_NUMBERS);
        }
    }

    public static LottoNumbers set(List<LottoNumber> lottoNumbers) {
        throwIllegalArgumentException(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
