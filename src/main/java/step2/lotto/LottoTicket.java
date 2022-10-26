package step2.lotto;

import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    private final Set<Integer> numbers;

    private LottoTicket(Set<Integer> numbers) {
        verifyNumbersSize(numbers);

        this.numbers = numbers;
    }

    private static void verifyNumbersSize(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    public static LottoTicket from(NumbersGenerator numbersGenerator) {
        return new LottoTicket(numbersGenerator.numbers());
    }

    public void printNumbers(OutputDevice outputDevice) {
        outputDevice.printNumbers(numbers);
    }

    public Rank rank(Set<Integer> winningNumbers) {
        verifyNumbersSize(winningNumbers);

        long numberOfMatchingNumbers = numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return Rank.rank(numberOfMatchingNumbers);
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
