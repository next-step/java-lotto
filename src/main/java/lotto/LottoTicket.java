package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    public static final int PRICE = 1_000;
    private final Set<LottoNumber> numbers;

    public LottoTicket(String[] numbers) {
        this(Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray());
    }

    public LottoTicket(int[] numbers) {
        if (numbers == null || numbers.length == 0 || numbers.length > 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        this.numbers = new HashSet<>();
        for (int number : numbers) {
            this.numbers.add(new LottoNumber(number));
        }
    }

    public LottoResult matchWinner(LottoTicket other) {
        int matchCount = (int) other.numbers.stream()
                .filter(this.numbers::contains)
                .count();
        return new LottoResult(this, new MatchCount(matchCount));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
