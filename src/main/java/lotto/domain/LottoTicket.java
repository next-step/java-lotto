package lotto.domain;

import static utils.IntegerValidator.*;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int REQUIRED_NUMBER_SIZE = 6;
    private static final String INVALID_SIZE_MESSAGE = "로또 입력 숫자는 6개여야 합니다.";

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validLottoNumberSize(numbers);

        this.numbers = Collections.unmodifiableList(
            getNumbersIfRange(numbers, MIN_NUMBER, MAX_NUMBER)
        );
    }

    private void validLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    public int matchOfNumberCount(LottoTicket lottoTicket) {
        return (int) numbers.stream()
            .filter(lottoTicket.numbers::contains).count();
    }

    public boolean matchOfNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
