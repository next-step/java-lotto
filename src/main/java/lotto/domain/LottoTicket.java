package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int PRICE = 1_000;
    public static final int NUMBER_LENGTH = 6;
    public static final String WRONG_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";
    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        validate(numbers.size());
        this.numbers = numbers;
    }

    public LottoTicket(String[] numbers) {
        this(Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public LottoTicket(int[] numbers) {
        this(Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private void validate(int size) {
        if (size != NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_NUMBER_COUNT + " 현재 개수: " + size);
        }
    }

    public LottoResult matchWinner(LottoTicket other, int bonusNumber) {
        int count = (int) other.numbers.stream()
                .filter(this.numbers::contains)
                .count();
        boolean isBonusMatch = this.numbers.contains(LottoNumber.of(bonusNumber));
        return new LottoResult(this, PrizeRank.of(MatchCount.of(count), isBonusMatch));
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
