package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("겹치지 않는 로또 숫자가 총 6개여야 합니다.");
        }

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public static LottoTicket random() {
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
        List<Integer> candidates = new ArrayList<>();
        for (int i = LottoNumber.VALUE_MIN; i <= LottoNumber.VALUE_MAX; i++) {
            candidates.add(i);
        }
        Collections.shuffle(candidates);
        return candidates.stream()
                .map(LottoNumber::new)
                .limit(LOTTO_NUMBER_COUNT)
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
