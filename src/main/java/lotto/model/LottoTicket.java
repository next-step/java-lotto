package lotto.model;

import lotto.AutomaticLottoGenerator;
import lotto.model.wrapper.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> numbers;

    private LottoTicket(final Set<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = new HashSet<>(numbers);
    }

    public static LottoTicket newInstance(final AutomaticLottoGenerator automaticLottoGenerator) {
        return new LottoTicket(automaticLottoGenerator.generate());
    }

    public static LottoTicket newInstance(final Set<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket newInstance(final int... numbers) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toSet());

        return new LottoTicket(lottoNumbers);
    }

    public Set<LottoNumber> getNumbers() {
        return new HashSet<>(numbers);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    private void validate(final Set<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또는 서로 다른 6개의 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
