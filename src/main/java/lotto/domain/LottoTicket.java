package lotto.domain;

import lotto.exception.IllegalLottoNumbersSizeException;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int NUMBER_INDEX_FROM = 0;
    public static final int NUMBER_INDEX_TO = 6;

    public static final int SIZE = NUMBER_INDEX_TO - NUMBER_INDEX_FROM;

    private final List<LottoNumber> numbers;

    public LottoTicket() {
        this(AllLottoNumber.shuffle()
                .stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList())
                .subList(NUMBER_INDEX_FROM, NUMBER_INDEX_TO)
        );
    }

    public LottoTicket(List<Integer> numbers) {
        validateNumbersSize(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateNumbersSize(List<Integer> numbers) throws IllegalLottoNumbersSizeException {
        if (notMatchSize(numbers)) {
            throw new IllegalLottoNumbersSizeException(SIZE, numbers.size());
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

    public List<LottoNumber> get() {
        return this.numbers;
    }

}
