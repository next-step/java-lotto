package lotto.model.lotto.strategy;

import lotto.model.lotto.LottoNumber;
import lotto.util.InputUtil;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualGenerationStrategy implements NumberGenerationStrategy {

    @Override
    public Set<LottoNumber> generateNumbers() {
        List<Integer> numbers = InputUtil.readNumbers();
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

}
