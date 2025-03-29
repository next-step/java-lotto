package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int PRICE = 1_000;
    public static final int NUMBER_LENGTH = 6;
    public static final String WRONG_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_NUMBER = "로또 번호는 중복될 수 없습니다.";
    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        ;
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

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_NUMBER_COUNT + " 현재 개수: " + numbers.size());
        }

        Set<LottoNumber> unique = new HashSet<>(numbers);
        if (unique.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER + " 입력: " + numbers);
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
