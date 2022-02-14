package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String NOT_VALIDATE_LOTTO_MESSAGE = "[ERROR] 로또는 중복되지 않은 6개의 숫자가 필요합니다.";
    private static final String NOT_VALIDATE_SIZE_LOTTO_MESSAGE = "[ERROR] 로또는 6개의 숫자가 필요합니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLotto();
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        validateDuplicates(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(Set<LottoNumber> lottoNumbers) {
        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public int count() {
        return lottoNumbers.size();
    }

    public boolean hasValue(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> values() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static void validateDuplicates(List<LottoNumber> lotto) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(lotto);
        if (lottoIsDuplicate(lottoNumbers, lotto)) {
            throw new IllegalArgumentException(NOT_VALIDATE_LOTTO_MESSAGE);
        }
    }

    private static boolean lottoIsDuplicate(Set<LottoNumber> lottoNumbers, List<LottoNumber> lotto) {
        return lottoNumbers.size() != lotto.size();
    }

    private void validateLotto() {
        if (lottoSizeNotValid()) {
            throw new IllegalArgumentException(NOT_VALIDATE_SIZE_LOTTO_MESSAGE);
        }
    }

    private boolean lottoSizeNotValid() {
        return lottoNumbers.size() != LOTTO_SIZE;
    }
}
