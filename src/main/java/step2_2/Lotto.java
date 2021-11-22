package step2_2;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }

}
