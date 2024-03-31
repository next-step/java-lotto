package lotto.domain.strategy;

import java.util.List;

public interface LottoNumberStrategy {
	int LOTTO_NUMBER_COUNT = 6;

	List<Integer> generateLottoNumber();
}
