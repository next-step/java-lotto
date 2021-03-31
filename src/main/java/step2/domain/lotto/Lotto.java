package step2.domain.lotto;

import step2.exception.ListNullPointerException;
import step2.exception.MissMatchSizeException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {

    private static final String COMMA_WITH_BLANK = ", ";
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static final Lotto of(String sentence) {
        return of(toLottoNumberSet(sentence));
    }

    public static final Lotto of(List<LottoNumber> lottoNumbers) {
        return of(new TreeSet<>(lottoNumbers));
    }

    public static final Lotto of(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private static final Set<LottoNumber> toLottoNumberSet(String sentence) {
        return Stream.of(sentence.split(COMMA_WITH_BLANK))
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    private final void validate(Set<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        if (isSizeMissNatch(lottoNumbers)) {
            throw new MissMatchSizeException();
        }
    }

    private static final boolean isSizeMissNatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_SIZE;
    }

    public final boolean contains(LottoNumber element) {
        return lottoNumbers.contains(element);
    }

    public final int getCorrectCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other::contains)
                .count();
    }

    public final Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
