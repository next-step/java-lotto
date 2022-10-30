package step2.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    private static final int NUMBER_OF_LOTTO = 6;

    private final Set<Integer> numbers;

    private LottoTicket(Set<Integer> numbers) {
        verifyNumbersSize(numbers);

        this.numbers = numbers;
    }

    private static void verifyNumbersSize(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    public static LottoTicket from(NumbersGenerator numbersGenerator) {
        return new LottoTicket(numbersGenerator.numbers());
    }

    public void printNumbers(OutputDevice outputDevice) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        outputDevice.printNumbers(copiedNumbers);
    }

    public Rank rank(LottoTicket winningLottoTicket) {
        long numberOfMatchingNumbers = numbers.stream()
                .filter(winningLottoTicket.numbers::contains)
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
