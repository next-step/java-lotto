package lotto.number;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("Input lotto numbers are null");
        }

        if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(
                    "Number of lotto numbers is " + lottoNumbers.size() + " number must equal to " + NUMBER_OF_LOTTO_NUMBERS
            );
        }
    }

    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }
}
