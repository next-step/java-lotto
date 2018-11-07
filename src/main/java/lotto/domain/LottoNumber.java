package lotto.domain;

import java.util.List;

/**
 * Created by hspark on 07/11/2018.
 */
public interface LottoNumber {
	List<Integer> getNumbers();

	LottoWinnerType matchNumber(LottoNumber lottoNumber);

	default int getMatchingCount(LottoNumber lottoNumber) {
		int matchingCount = 0;
		for (Integer number : lottoNumber.getNumbers()) {
			matchingCount += getNumbers().contains(number) ? 1 : 0;
		}
		return matchingCount;
	}
}
