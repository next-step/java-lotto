package lotto.domain;

import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public interface LottoMachine {
	default List<Integer> drawLottoNumbers() {
		List<Integer> lottoNumbers = draw();
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}

	List<Integer> draw();
}
