package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int TOTAL_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateLottoNumbers(lottoNumbers);
    }

    public Award match(WinningLotto winningLotto) {

        return Award.valueOf(Math.toIntExact(
                lottoNumbers.stream()
                .filter(lottoNumber -> winningLotto.contains(lottoNumber))
                .count()),
                winningLotto.checkBonusNumber(lottoNumbers)
        );
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
