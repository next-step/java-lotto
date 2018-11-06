package lotto.domain;

import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public interface LottoMachine {
	default List<Integer> drawLottoNumbers() {
		List<Integer> lottoNumbers = draw();
		if (lottoNumbers.size() > 6) {
			throw new RuntimeException();
		}
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}

	List<Integer> draw();
}
