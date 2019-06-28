package lotto.model.generator;

import lotto.exception.NumbersIsEmptyException;
import lotto.model.Lotto;
import lotto.utils.StringUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;


public class ManualLottoGenerator implements LottoGenerator {

    private List<String> numbers;

    public ManualLottoGenerator(List<String> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NumbersIsEmptyException();
        }
        this.numbers = numbers;
    }

    @Override
    public List<Lotto> generator() {
        return numbers.stream()
                .map(StringUtils::parseLotto)
                .collect(toList());
    }
}