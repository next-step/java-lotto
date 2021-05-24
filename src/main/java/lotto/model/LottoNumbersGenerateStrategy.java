package lotto.model;

import java.util.List;

public interface LottoNumbersGenerateStrategy {
	int FROM_ZERO = 0;

	List<LottoNumbers> generate(int count);
}
