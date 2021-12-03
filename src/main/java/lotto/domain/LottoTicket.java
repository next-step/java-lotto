package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE = 1000;
    private static final int REQUIRED_NUMBER_SIZE = 6;
    private static final String INVALID_SIZE_MESSAGE = "로또 입력 숫자는 6개여야 합니다.";

    private final List<LottoNumber> numbers;

    public LottoTicket(List<Integer> numbers) {
        validLottoNumberSize(numbers);

        this.numbers = Collections.unmodifiableList(
            numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
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
        return numbers.contains(new LottoNumber(number));
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(getNumbers(), that.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbers());
    }

}
