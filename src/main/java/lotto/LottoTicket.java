package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket() {
        this(createLottoNumbers());
    }

    public LottoTicket(int... numbers) {
        this(toLottoNumbers(numbers));
    }

    public LottoTicket(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean hasNumber(int number) {
        return hasNumber(new LottoNumber(number));
    }

    public boolean hasNumber(LottoNumber number) {
        return this.numbers.contains(number);
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
