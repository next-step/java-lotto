package step2.model;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력 가능합니다.");
        }

        if (isDuplicateExist(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        this.numbers = numbers;
    }

    private boolean isInvalidCount(List<LottoNumber> numbers) {
        return numbers == null || numbers.size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    private boolean isDuplicateExist(List<LottoNumber> numbers) {
        return new HashSet<>(numbers).size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public static LottoTicket create(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int getMatchCount(WinningNumbers winningNumbers) {
        return Math.toIntExact(this.numbers.stream()
                .filter(winningNumbers::containsNumber)
                .count());
    }

    @Override
    public String toString() {
        return MessageFormat.format("LottoNumber :: {0}", numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
