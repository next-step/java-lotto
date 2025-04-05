package lotto.domain;

import java.util.List;
import java.util.Set;

public interface NumberGenerationStrategy {

    Set<LottoNumber> generateNumbers();
}
