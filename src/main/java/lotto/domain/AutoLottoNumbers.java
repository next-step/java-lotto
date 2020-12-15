package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public AutoLottoNumbers(List<LottoNumber> lottoNumbers) {
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

	@Override
	public String toString() {
		return this.lottoNumbers.stream()
			.map(LottoNumber::toString)
			.collect(Collectors.joining("\n"));
	}
}
