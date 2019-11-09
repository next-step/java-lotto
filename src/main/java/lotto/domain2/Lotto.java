package lotto.domain2;

import java.util.List;
import java.util.Objects;

public class Lotto {
    static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;
    private final boolean isDirect;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this(lottoNumbers, false);
    }

    public Lotto(final List<LottoNumber> numbers, final boolean isDirect) {
        if (NUMBER_COUNT != numbers.size()) {
            throw new IllegalArgumentException(String.format("로또번호의 개수는 %s개만 가능합니다. 입력받은 로또번호 개수 = %s", NUMBER_COUNT, numbers.size()));
        }

        this.lottoNumbers = numbers;
        this.isDirect = isDirect;
    }

    int getCountOfMatchWith(final List<LottoNumber> winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    boolean isMatchBonus(final int bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(LottoNumber.of(bonusNumber)));
    }

    boolean isDirect() {
        return this.isDirect;
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

    @Override
    public String toString() {
        return String.join(", ", (CharSequence) lottoNumbers);
    }
}
