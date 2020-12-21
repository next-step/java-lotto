package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class ResultView {
	public void printLottoNumbers(LottoNumbers lottoNumbers) {
		for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
			System.out.println(lottoNumber);
		}
		System.out.println();
	}

	public void printLottoGameCount(int lottoGameCount) {
		System.out.println(lottoGameCount + "개를 구매했습니다.");
	}
}
