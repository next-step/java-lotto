package step2_2;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize6(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkSize6(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoNumberCountMisMatchException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }

}
