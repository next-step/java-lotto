package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.LottoException;

public class Lotto {

    private static final String LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_MADE_OF_NUMBERS = 6;
    private final LottoNumbers lottoNumbers;

    private Lotto(final LottoNumbers lottoNumbers) {
        if (lottoNumbers.getSize() != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(final LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    public boolean containBonusNumber(final int bonusNumber) {
        return lottoNumbers.contains(new LottoNumber(bonusNumber));
    }

    public long matchCount(Lotto lotto) {
        List<LottoNumber> numberList = lotto.stream().collect(Collectors.toList());
        return lottoNumbers.stream()
                .filter(numberList::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
