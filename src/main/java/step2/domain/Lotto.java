package step2.domain;

import step2.exception.LottoException;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int NUMBER_OF_LOTTONUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_OF_LOTTONUMBERS) {
            throw new LottoException("로또 번호는 6개여야 합니다.");
        }
    }

    public int numberOfMatching(LottoWinningNumbers lottoWinningNumbers) {
        int numberOfMatching = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            numberOfMatching += lottoWinningNumbers.numberOfMatching(lottoNumber);
        }
        return numberOfMatching;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
