package lotto.model;

import lotto.AutomaticLottoGenerator;
import lotto.model.wrapper.LottoNumber;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> numbers;

    private LottoTicket(final Set<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = new HashSet(numbers);
    }

    private void validate(final Set<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }

    public static LottoTicket newInstance() {
        return new LottoTicket(AutomaticLottoGenerator.generate());
    }

    public static LottoTicket newInstance(final Set<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public Set<LottoNumber> getNumbers() {
        return new HashSet<>(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
