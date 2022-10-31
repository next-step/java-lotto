package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public static LottoTicket create() {
        return new LottoTicket(createLottoNumbers());
    }

    public static LottoTicket from(int... numbers) {
        return new LottoTicket(toLottoNumbers(numbers));
    }

    public static LottoTicket from(List<Integer> numbers) {
        return new LottoTicket(toLottoNumbers(numbers));
    }

    public boolean hasNumber(int number) {
        return hasNumber(new LottoNumber(number));
    }

    public boolean hasNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int getMatchingCount(LottoTicket ticket) {
        return (int) numbers.stream()
                .filter(ticket::hasNumber)
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
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

    private static List<LottoNumber> createLottoNumbers() {
        return IntStream.range(0, LOTTO_NUMBER_COUNT)
                .mapToObj(i -> new LottoNumber())
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
