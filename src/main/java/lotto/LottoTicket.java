package lotto;

import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
	private final List<LottoNumbers> lottoNumbers;

	public LottoTicket(List<LottoNumbers> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	LottoStatistics compareNumbers(WinningNumbers winningNumbers) {
		List<LottoResult> lottoResultList = this.lottoNumbers.stream()
				.map(winningNumbers::findMatchedResult)
				.collect(Collectors.toList());
		return new LottoStatistics(lottoResultList);
	}

	public int size() {
		return lottoNumbers.size();
	}

	public List<String> toStringNumbers() {
		return this.lottoNumbers.stream()
				.map(LottoNumbers::toString)
				.collect(Collectors.toList());
	}
}
