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
        this.numbers = numbers;
    }

    public static LottoTicket from(NumbersGenerator numbersGenerator) {
        Set<Integer> numbers = numbersGenerator.numbers();
        verifyNumbers(numbers);

        return new LottoTicket(numbers);
    }

    private static void verifyNumbers(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }

        boolean isValidNumber = numbers.stream().anyMatch(number -> number < 1 ||  45 < number);
        if (isValidNumber) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45이하 이어야 합니다.");
        }

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
