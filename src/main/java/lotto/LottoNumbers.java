package lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public LottoMatchResults match(LottoMatchResults results, WinningNumber winningNumber) {
		for(LottoNumber lottoNumber : lottoNumbers) {
			results.addResult(winningNumber.match(lottoNumber));
		}
		return results;
	}

	public int getLottoNumbersSize() {
		return this.lottoNumbers.size();
	}
}
