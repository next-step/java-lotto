package lottogame;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {

    private final List<LottoNumber> lotto;

    public Lotto(final List<Integer> values) {
        validate(values);
        this.lotto = convertToLottoNumbers(values);
    }

    private void validate(final List<Integer> values) {
        validateSize(values);
        validateDuplicate(values);
    }

    private static void validateDuplicate(final List<Integer> values) {
        HashSet<Integer> distinctValues = new HashSet<>(values);
        if (distinctValues.size() != values.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야합니다");
        }
    }

    private void validateSize(final List<Integer> values) {
        if (values.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야합니다");
        }
    }

    private List<LottoNumber> convertToLottoNumbers(final List<Integer> values) {
        return values.stream()
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

    public String getLottoNumbers() {
        return lotto.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.joining(", "));
    }

}
