package step4.domain.lotto;

import step4.exception.InputInvalidStringLottoException;
import step4.exception.LottoSizeMissMatchException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {

    public static final String COMMA_WITH_BLANK = ", ";
    public static final int SIZE = 6;
    public static final int AMOUNT = 1000;

    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        validateSize(lotto);
        this.lotto = lotto;
    }

    public static final Lotto of(List<LottoNumber> lotto) {
        return of(new HashSet<>(lotto));
    }

    public static final Lotto of(Set<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    public static final Lotto of(String lotto) {
        return of(convertStringToLottoNumberSet(lotto));
    }

    private static final Set<LottoNumber> convertStringToLottoNumberSet(String sentence) {
        validateStringFormat(sentence);
        return Stream.of(sentence.split(COMMA_WITH_BLANK))
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private static void validateStringFormat(String sentence) {
        if(sentence.split(COMMA_WITH_BLANK).length != SIZE) {
            throw new InputInvalidStringLottoException();
        }
    }

    private final void validateSize(Set<LottoNumber> lotto) {
        if (lotto.size() != SIZE) {
            throw new LottoSizeMissMatchException();
        }
    }

    public final boolean isIncludeLottoNumber(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public final int match(Lotto anotherLotto) {
        return (int) lotto.stream()
                .filter(anotherLotto::isIncludeLottoNumber)
                .count();
    }

    public final Set<LottoNumber> getLotto() {
        return lotto;
    }
}
