package lotto.domain;

import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public interface LottoMachine {
	default List<Integer> drawLottNumbers() {
		List<Integer> lottoNumbers = draw();
		if (lottoNumbers.size() > 6) {
			throw new RuntimeException();
		}
		return lottoNumbers;
	}

	List<Integer> draw();
}
