package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hspark on 06/11/2018.
 */
public interface LottoMachine {
	default List<LottoNumber> drawLottoNumbers() {
		List<Integer> lottoNumbers = draw();
		Collections.sort(lottoNumbers);
		return lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
	}

	List<Integer> draw();
}
