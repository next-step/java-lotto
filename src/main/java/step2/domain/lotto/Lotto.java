package step2.domain.lotto;

import step2.exception.ListNullPointerException;
import step2.exception.LottoSizeMissMatchException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {

    private static final String COMMA = ",";
    private static final int LOTTO_SIZE = 6;
    private static final int EACH_COUNT = 1;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(String sentence) {
        this(toLottoNumberList(sentence));
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isListNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        if(isSizeMissNatch(lottoNumbers)) {
            throw new LottoSizeMissMatchException();
        }
        this.lottoNumbers = lottoNumbers;
    }


    public static final Lotto newInstance(String sentence) {
        return new Lotto(sentence);
    }

    public static final Lotto newInstance(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private static final List<LottoNumber> toLottoNumberList(String sentence) {
        return Stream.of(sentence.split(COMMA))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public final int getCorrectCount(Lotto other) {
        return lottoNumbers.stream()
                .filter(other::contains)
                .mapToInt(i -> EACH_COUNT)
                .sum();
    }

    private final boolean isListNull(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null;
    }

    private final boolean isSizeMissNatch(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_SIZE;
    }

    public final boolean contains(LottoNumber element) {
        return lottoNumbers.contains(element);
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
