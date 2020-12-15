package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public LottoMatchResults match(WinningNumber winningNumber) {
		LottoMatchResults results = new LottoMatchResults();
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

	public LottoNumbers addNumbers(LottoNumbers addedNumbers) {
		List<LottoNumber> newLottoNumbers = new ArrayList<>(this.lottoNumbers);
		newLottoNumbers.addAll(addedNumbers.lottoNumbers);
		return new LottoNumbers(newLottoNumbers);
	}

	public LottoNumbers getAutoLottoNumbers() {
		List<LottoNumber> autoNumbers = this.lottoNumbers.stream()
			.filter(LottoNumber::isAuto)
			.collect(Collectors.toList());
		return new LottoNumbers(autoNumbers);
	}
}
