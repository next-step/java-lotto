package lotto.model;

import java.util.List;

public interface LottoNumbersGenerateStrategy {
	List<LottoNumbers> generate(Count count);
}
