package lotto.model.lotto.strategy;

import lotto.model.lotto.LottoNumber;
import lotto.util.InputUtil;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualGenerationStrategy implements NumberGenerationStrategy {

    @Override
    public Set<LottoNumber> generateLottoNumbers() {
        List<Integer> numbers = InputUtil.readNumbers();
        return numbers.stream()
                .map(LottoNumber::create)
                .collect(Collectors.toSet());
    }

}
