package lotto.domain;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lotto {

    public static final int MAX_LOTTO_COUNT = 6;
    private final List<LottoNumber> lotto;

    public Lotto(final List<Integer> values) {
        validate(values);
        this.lotto = toLottoNumbers(values);
    }

    private void validate(final List<Integer> values) {
        validateSize(values);
        validateDuplicate(values);
    }

    private static void validateDuplicate(final List<Integer> values) {
        if (values.size() != values.stream().distinct().count()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야합니다");
        }
    }

    private void validateSize(final List<Integer> values) {
        if (values.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(
                    MessageFormat.format("로또 번호는 {0}개여야합니다. 현재 개수 : {1}개", MAX_LOTTO_COUNT, values.size())
            );
        }
    }

    private List<LottoNumber> toLottoNumbers(final List<Integer> values) {
        return values.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public boolean hasLottoNumber(final LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int countMatch(final Lotto winningLotto) {
        return Math.toIntExact(winningLotto.lotto.stream()
            .filter(this::hasLottoNumber)
            .count());
    }

    public List<LottoNumber> getLotto() {
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
