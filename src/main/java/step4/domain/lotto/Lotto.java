package step4.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String MIN_SIZE_EXCEPTION = "로또번호는 6개여야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicatingLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateDuplicatingLottoNumbers(List<LottoNumber> lottoNumbers) {
        boolean duplication = lottoNumbers.stream()
            .distinct()
            .count() != lottoNumbers.size();

        if (duplication) {
            throw new IllegalArgumentException("이미 존재하는 로또 번호입니다.");
        }
    }

    public static Lotto create(List<LottoNumber> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(MIN_SIZE_EXCEPTION);
        }
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }


}
