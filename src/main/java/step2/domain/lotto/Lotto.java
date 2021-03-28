package step2.domain.lotto;

import step2.exception.ListNullPointerException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {

    private static final String COMMA = ",";
    private final List<LottoNumber> lottoNumbers;

    public static final Lotto newInstance(String sentence) {
        return new Lotto(sentence);
    }

    public static final Lotto newInstance(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public Lotto(String sentence) {
        this(toLottoNumberList(sentence));
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isListNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    private final boolean isListNull(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null;
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
                .mapToInt(i -> 1)
                .sum();
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
