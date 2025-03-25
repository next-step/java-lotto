package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    public static final int PRICE = 1_000;
    public static final int NUMBER_LENGTH = 6;
    public static final String WRONG_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";
    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(String[] numbers) {
        this(Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray());
    }

    public LottoTicket(int[] numbers) {
        if (numbers == null || numbers.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_NUMBER_COUNT);
        }

        this.numbers = new HashSet<>();
        for (int number : numbers) {
            this.numbers.add(LottoNumber.of(number));
        }
    }

    public LottoResult matchWinner(LottoTicket other) {
        int matchCount = (int) other.numbers.stream()
                .filter(this.numbers::contains)
                .count();
        return new LottoResult(this, MatchCount.of(matchCount));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket ticket = (LottoTicket) o;
        return Objects.equals(numbers, ticket.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
