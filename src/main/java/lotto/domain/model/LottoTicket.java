package lotto.domain.model;

import java.util.List;

import static lotto.constant.LottoConstants.*;

public class LottoTicket {
    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
        validate();
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    private void validate() {
        validateSize();
        validateNoDuplicates();
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto numbers must contain exactly 6 numbers.");
        }
    }

    private void validateNoDuplicates() {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("Lotto numbers must not contain duplicates.");
        }
    }
}
