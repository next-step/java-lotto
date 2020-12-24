package lotto;

import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.option.LottoMoney;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
	private static final String VALIDATE_FAIL_MSG = "the sum of two lists'size must be at least one";
	private final List<LottoNumbers> autoNumbers;
	private final List<LottoNumbers> manualNumbers;

	public LottoTicket(List<LottoNumbers> autoNumbers, List<LottoNumbers> manualNumbers) {
		validate(autoNumbers, manualNumbers);
		this.autoNumbers = autoNumbers;
		this.manualNumbers = manualNumbers;
	}

	private static void validate(List<LottoNumbers> autoNumbers, List<LottoNumbers> manualNumbers)
			throws IllegalArgumentException {
		if (autoNumbers.isEmpty() && manualNumbers.isEmpty()) {
			throw new IllegalArgumentException(VALIDATE_FAIL_MSG);
		}
	}

	LottoStatistics compareNumbers(WinningNumbers winningNumbers, LottoMoney buyMoney) {
		List<LottoResult> lottoResultList = this.getMergedStream()
				.map(winningNumbers::findMatchedResult)
				.collect(Collectors.toList());
		return new LottoStatistics(lottoResultList, buyMoney);
	}

	public List<String> toStringNumbers() {
		return this.getMergedStream()
				.map(LottoNumbers::toString)
				.collect(Collectors.toList());
	}

	private Stream<LottoNumbers> getMergedStream() {
		return Stream.concat(this.autoNumbers.stream(), this.manualNumbers.stream());
	}

	public int autoNumbersSize() {
		return this.autoNumbers.size();
	}

	public int manualNumbersSize() {
		return this.manualNumbers.size();
	}
}
