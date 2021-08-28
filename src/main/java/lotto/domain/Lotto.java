package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int TOTAL_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoLottoNumbers;

    public Lotto(Set<LottoNumber> lottoLottoNumbers) {
        this.lottoLottoNumbers = new TreeSet<>(lottoLottoNumbers);
        validateLottoNumbers(lottoLottoNumbers);
    }

    public Award match(Lotto other) {
        return Award.valueOf(Math.toIntExact(
                lottoLottoNumbers.stream()
                .filter(lottoNumber -> other.lottoLottoNumbers.contains(lottoNumber))
                .count())
        );
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 6개가 아닙니다.");
        }

        if (lottoLottoNumbers.size() != new HashSet<>(lottoLottoNumbers).size()) {
            throw new IllegalArgumentException("입력된 숫자가 중복");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoLottoNumbers);
    }
}
