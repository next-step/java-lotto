package step2.lotto;

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

    public void print(OutputView outputView) {
        outputView.print(numbers);
    }
}
