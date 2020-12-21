package lotto;

import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
	public static final String VALIDATE_FAIL_MSG = "the sum of two lists'size must be at least one";
	private final List<LottoNumbers> autoNumbers;
	private final List<LottoNumbers> manualNumbers;

	public LottoTicket(List<LottoNumbers> autoNumbers, List<LottoNumbers> manualNumbers) {
		validate(autoNumbers, manualNumbers);
		this.autoNumbers = Collections.unmodifiableList(autoNumbers);
		this.manualNumbers = Collections.unmodifiableList(manualNumbers);
	}

	private static void validate(List<LottoNumbers> autoNumbers, List<LottoNumbers> manualNumbers)
			throws IllegalArgumentException {
		if (autoNumbers.size() + manualNumbers.size() == 0) {
			throw new IllegalArgumentException(VALIDATE_FAIL_MSG);
		}
	}

	LottoStatistics compareNumbers(WinningNumbers winningNumbers) {
		List<LottoResult> lottoResultList = this.getMergedStream()
				.map(winningNumbers::findMatchedResult)
				.collect(Collectors.toList());
		return new LottoStatistics(lottoResultList);
	}

	public List<String> toStringNumbers() {
		return this.getMergedStream()
				.map(LottoNumbers::toString)
				.collect(Collectors.toList());
	}

	private Stream<LottoNumbers> getMergedStream() {
		return Stream.concat(this.autoNumbers.stream(), this.manualNumbers.stream());
	}

	public int size() { // TODO : remove
		return this.autoNumbers.size() + this.manualNumbers.size();
	}

	public int autoNumbersSize() {
		return this.autoNumbers.size();
	}

	public int manualNumbersSize() {
		return this.manualNumbers.size();
	}
}
