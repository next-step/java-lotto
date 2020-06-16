package step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Integer> numbers;

    private LottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static LottoTicket newLottoTicket(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket newLottoTicketFromString(String stringWinningNumbers) {
        String[] split = stringWinningNumbers.split(",");

        return new LottoTicket(Arrays.stream(split)
                .map(winningNumber -> Integer.parseInt(winningNumber.trim()))
                .collect(Collectors.toList()));
    }

    public List<Integer> getNumbers() {
        return numbers;
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

    public List<Integer> checkLottoWinning(List<LottoTicket> lottoTicketList) {
        return lottoTicketList.stream().map(this::compareLottoNumber).collect(Collectors.toList());
    }

    private int compareLottoNumber(LottoTicket lottoTicket) {
        List<Integer> myLottoNumbers = lottoTicket.getNumbers();

        return (int) this.numbers.stream().filter(myLottoNumbers::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
