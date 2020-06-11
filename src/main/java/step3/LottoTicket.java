package step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<Integer> numbers;

    public static LottoTicket makeLottoTicket(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket makeWinningLottoTicket(String stringWinningNumbers) {
        String[] split = stringWinningNumbers.split(",");
        List<Integer> winningLottoNumbers = Arrays.stream(split).map(winningNumber
                -> Integer.parseInt(winningNumber.trim())).collect(Collectors.toList());
        return new LottoTicket(winningLottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private LottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        numbers.forEach(integer -> {
            if (integer < 1 || integer > 45) {
                throw new IllegalArgumentException();
            }
        });
    }
}
