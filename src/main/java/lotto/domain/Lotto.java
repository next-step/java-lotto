package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final static int COUNTS_OF_LOTTO_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLength(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public int compareNumber(final Lotto anotherLotto) {
        return (int)lottoNumbers.stream()
                .filter(lotto -> anotherLotto.contains(lotto))
                .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void validateLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNTS_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 여섯 자리여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().collect(Collectors.toList()).size() != COUNTS_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호에는 중복된 숫자가 들어갈 수 없습니다.");
        }
    }
}
