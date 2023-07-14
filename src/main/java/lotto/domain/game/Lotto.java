package lotto.domain.game;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(final List<Integer> values, final boolean isAuto) {
        validate(values, isAuto);
        this.lotto = toLottoNumbers(values);
    }

    private void validate(final List<Integer> values, final boolean isAuto) {
        validateSize(values, isAuto);
        validateDuplicate(values);
    }

    private static void validateDuplicate(final List<Integer> values) {
        HashSet<Integer> distinctValues = new HashSet<>(values);
        if (distinctValues.size() != values.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야합니다");
        }
    }

    private void validateSize(final List<Integer> values, final boolean isAuto) {
        if (values.size() < LOTTO_SIZE || (LOTTO_SIZE < values.size() && !isAuto)) {
            throw new IllegalArgumentException("로또 번호는 6개여야합니다");
        }
    }

    private List<LottoNumber> toLottoNumbers(final List<Integer> values) {
        return values.stream()
            .limit(LOTTO_SIZE)
            .map(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public boolean hasLottoNumber(final LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int countMatch(final Lotto winningLotto) {
        return (int) winningLotto.lotto.stream()
            .filter(this::hasLottoNumber)
            .count();
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

}
