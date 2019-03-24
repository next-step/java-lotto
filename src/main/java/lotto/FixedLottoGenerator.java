package lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split;

public class FixedLottoGenerator extends LottoGenerator {
    private Set<LottoNumber> numbers;

    public FixedLottoGenerator(final String numbers) {
        this.numbers = convertToLottoNumber(convertToInt(split(numbers)));
    }

    @Override
    public Lotto generateLotto() {
        Set<LottoNumber> newNumbers = new HashSet<>(numbers);
        numbers = numbers.stream().map(LottoNumber::increase).collect(Collectors.toSet());
        return new Lotto(newNumbers);
    }
}