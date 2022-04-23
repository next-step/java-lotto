package lotto.model.lotto.strategy;

import lotto.model.lotto.LottoNumber;
import lotto.util.InputUtil;

import java.util.Set;

public class ManualGenerationStrategy implements NumberGenerationStrategy {

    @Override
    public Set<LottoNumber> generateLottoNumbers() {
        return InputUtil.readNumbers();
    }

}
