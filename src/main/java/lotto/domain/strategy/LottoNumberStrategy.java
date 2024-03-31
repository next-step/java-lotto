package lotto.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface LottoNumberStrategy {
	int LOTTO_NUMBER_COUNT = 6;
	int LOTTO_NUMBER_MIN = 1;
	int LOTTO_NUMBER_MAX = 45;

	List<Integer> generateLottoNumber();
}
