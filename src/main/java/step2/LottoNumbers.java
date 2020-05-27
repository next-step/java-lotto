package step2;

import java.util.List;

public class LottoNumbers {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers newInstance(List<LottoNumber> lottoNumbers) {
        if (!isValidLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호 개수가 일치하지 않습니다");
        }

        return new LottoNumbers(lottoNumbers);
    }

    private static boolean isValidLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers != null && lottoNumbers.size() == ALLOWED_LOTTO_NUMBER_COUNT;
    }
}
