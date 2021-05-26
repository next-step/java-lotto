package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static lotto.domain.LottoOptions.LOTTO_SIZE;

/**
 * 서로 다른 6가지의 로또 번호를 가지고 있는 객체
 */
public final class Lotto {
    public static final String LOTTO_NUMBER_SIZE_MESSAGE = "로또 번호는 중복되지 않은 숫자로 최소 6개를 가지고 있어야 합니다.";
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final LottoNumberGenerator lottoNumberGenerator) {
        this(lottoNumberGenerator.drawLots());
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int matchCount(final Lotto toCompareLotto) {
        return (int) lottoNumbers.stream()
                .filter(toCompareLotto::isContains)
                .count();
    }

    public boolean isContains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
