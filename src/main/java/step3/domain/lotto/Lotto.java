package step3.domain.lotto;

import step3.exception.LottoSizeMissMatchException;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {

    public static final int PRICE = 1000;

    private static final String COMMA_WITH_BLANK = ", ";
    private static final int STANDARD_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validateSize(lotto);
        this.lotto = lotto;
    }

    public static final Lotto of(String sentence) {
        return of(convertStringToLottoNumberSet(sentence));
    }

    public static final Lotto of(Set<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    private static final Set<LottoNumber> convertStringToLottoNumberSet(String sentence) {
        return Stream.of(sentence.split(COMMA_WITH_BLANK))
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private final void validateSize(Set<LottoNumber> lotto) {
        if (lotto.size() != STANDARD_SIZE) {
            throw new LottoSizeMissMatchException();
        }
    }

    public final int getCountOfMatch(Lotto targetLotto) {
        return (int) lotto.stream()
                .filter(targetLotto::isIncludeLottoNumber)
                .count();
    }

    public final boolean isIncludeLottoNumber(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public final Set<LottoNumber> getLottoNumbers() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }


}