package Lotto.domain;

import java.util.*;

import static Lotto.domain.LottoList.LOTTO_PICK_COUNT;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("로또 번호는 반드시 6개여야 합니다.");
        }
        if (new HashSet<>(lottoNumbers).size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int countMatches(Set<LottoNumber> winningNumbers) {
        Set<LottoNumber> intersection = new HashSet<>(this.lottoNumbers);
        intersection.retainAll(winningNumbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
