package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Long> lottoNumbers;

    public Lotto(final List<Long> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void validateSize(final List<Long> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private static void validateDuplicate(final List<Long> lottoNumbers) {
        HashSet<Long> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

    public List<Long> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
