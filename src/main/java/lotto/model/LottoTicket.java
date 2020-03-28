package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.utils.LottoConstant.LOTTO_NUMBER_SIZE;

public abstract class LottoTicket {
    protected List<LottoNumber> numbers;

    protected LottoTicket(final List<LottoNumber> numbers) {
        validate(numbers);

        Collections.sort(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(final List<LottoNumber> numbers) {
        validateNullOrEmpty(numbers);
        validateSize(numbers);
    }

    private void validateNullOrEmpty(final List<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.isEmpty()) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }

    private void validateSize(final List<LottoNumber> numbers) {
        int size = (int) numbers.stream()
                .distinct()
                .count();
        if (size != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }
}
