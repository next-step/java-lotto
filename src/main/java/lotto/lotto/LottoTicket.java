package lotto.lotto;

import lotto.utils.RandomLottoNumbersGenerator;
import lotto.utils.StringToListIntegerConverter;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = RandomLottoNumbersGenerator.generate();
    }

    public LottoTicket(String numbers) {
        this.numbers = StringToListIntegerConverter.convert(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public LottoReward match(LottoWinNumbers lottoWinNumbers) {
        List<Integer> matchNumbers = lottoWinNumbers.getNumbers();
        matchNumbers.retainAll(numbers);
        return LottoReward.valueOfMatchCount(matchNumbers.size());
    }
}
