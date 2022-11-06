package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_NUMBER_COUNT = 6;

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
        return new LottoTicket(randomLottoNumbers());
    }

    public static LottoTicket of(int... numbers) {
        return new LottoTicket(toLottoNumbers(numbers));
    }

    public static LottoTicket of(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public boolean hasNumber(LottoNumber number) {
        return this.numbers.contains(number);
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

    private static List<LottoNumber> randomLottoNumbers() {
        List<LottoNumber> candidates = new ArrayList<>(LottoNumber.selectableNumbers());
        Collections.shuffle(candidates);
        return candidates.subList(0, LOTTO_NUMBER_COUNT);
    }

    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public int getMatchCount(LottoTicket ticket) {
        return (int) numbers.stream()
                .filter(ticket::hasNumber)
                .count();
    }
}
