package step2.domain.lotto;

import step2.exception.ListNullPointerException;
import step2.exception.MissMatchSizeException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {

    private static final String COMMA_WITH_BLANK = ", ";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static final Lotto of(String sentence) {
        return new Lotto(toLottoNumberList(sentence));
    }

    public static final Lotto of(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static final List<LottoNumber> toLottoNumberList(String sentence) {
        return Stream.of(sentence.trim().split(COMMA_WITH_BLANK))
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private static final void validate(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        if (isSizeMissNatch(lottoNumbers)) {
            throw new MissMatchSizeException();
        }
    }

    private static final boolean isSizeMissNatch(List<LottoNumber> lottoNumbers) {
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

    public final List<LottoNumber> getLottoNumbers() {
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
