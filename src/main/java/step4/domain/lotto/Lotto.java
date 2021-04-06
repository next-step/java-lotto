package step4.domain.lotto;

import step4.exception.LottoSizeMissMatchException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {

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
}
