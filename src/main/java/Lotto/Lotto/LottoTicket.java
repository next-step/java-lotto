package Lotto.Lotto;

import Lotto.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String SPLITTER = ",";

    private final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = Random.generateRandomLottoNumbers();
    }

    public LottoTicket(String numbers) {
        this.numbers = Arrays.stream(numbers.split(SPLITTER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
