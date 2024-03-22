package lotto.domain;

import lotto.exception.IllegalLottoNumbersSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket() {
        this(LottoNumberGenerator.generate());
    }

    public LottoTicket(List<Integer> numbers) {
        validateNumbersSize(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateNumbersSize(List<Integer> numbers) throws IllegalLottoNumbersSizeException {
        if (notMatchSize(numbers)) {
            throw new IllegalLottoNumbersSizeException(numbers.size());
        }
    }

    private boolean notMatchSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    public LottoPrize getPrize(LottoTicket winLottoTicket) {
        int matchCount = count(winLottoTicket.numbers);
        return LottoPrize.lookup(matchCount);
    }

    private int count(List<LottoNumber> numbers) {
        return (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber number : this.numbers) {
            lottoNumbers.add(number.get());
        }
        return lottoNumbers;
    }

}
