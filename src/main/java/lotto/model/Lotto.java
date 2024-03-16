package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(Integer... numbers) {
        this(LottoNumbers.of(numbers));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        assertLotto(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void assertLotto(List<LottoNumber> lottoNumbers) {
        assertNullOrEmpty(lottoNumbers);
        assertInvalidSize(lottoNumbers);
    }

    private void assertNullOrEmpty(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new InvalidLottoException("로또 번호가 비어 있습니다");
        }
    }

    private void assertInvalidSize(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoException("중복을 제외한 " + LOTTO_NUMBER_SIZE + "개의 로또 번호가 필요합니다");
        }
    }

    public int matches(List<LottoNumber> others) {
        assertNullOrEmpty(others);

        return others.stream()
                .distinct()
                .map(this::match)
                .reduce(0, Integer::sum);
    }

    public int match(LottoNumber other) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.equals(other))
                .count();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
