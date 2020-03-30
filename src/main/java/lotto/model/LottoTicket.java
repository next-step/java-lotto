package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.utils.LottoConstant.LOTTO_NUMBER_SIZE;

public abstract class LottoTicket {
    protected Set<LottoNumber> numbers;

    protected LottoTicket(final Set<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = new HashSet(numbers);
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    private void validate(final Set<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
