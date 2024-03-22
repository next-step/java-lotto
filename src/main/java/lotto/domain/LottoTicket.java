package lotto.domain;

import lotto.exception.IllegalLottoNumbersSizeException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.NUMBER_RANGE_FROM;
import static lotto.domain.LottoNumber.NUMBER_RANGE_TO;

public class LottoTicket {

    public static final int NUMBER_INDEX_FROM = 0;
    public static final int NUMBER_INDEX_TO = 6;

    public static final int SIZE = NUMBER_INDEX_TO - NUMBER_INDEX_FROM;

    private final List<LottoNumber> numbers;

    public LottoTicket() {
        this(autoNumbers());
    }

    public LottoTicket(List<Integer> numbers) {
        validateNumbersSize(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<Integer> autoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(NUMBER_RANGE_FROM, NUMBER_RANGE_TO)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(NUMBER_INDEX_FROM, NUMBER_INDEX_TO);
    }

    private void validateNumbersSize(List<Integer> numbers) throws IllegalLottoNumbersSizeException {
        if (notMatchSize(numbers)) {
            throw new IllegalLottoNumbersSizeException(SIZE, numbers.size());
        }
    }

    private boolean notMatchSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    public Rank getRank(WinLotto winLotto) {
        int matchCount = count(winLotto.getWinLotto());
        boolean matchBonus = isMatchBonus(winLotto.getBonusNumber());
        return Rank.valueOf(matchCount, matchBonus);
    }

    private boolean isMatchBonus(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int count(LottoTicket winLotto) {
        return (int) winLotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public List<LottoNumber> get() {
        return this.numbers;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

}
