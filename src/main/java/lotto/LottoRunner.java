package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {
	private final List<LottoNumber> lottoNumbers;
	private static final int PRICE_PER_LOTTO_NUMBER = 1000;

	public LottoRunner(int payment) {
		this.lottoNumbers = generateNumbers(payment / PRICE_PER_LOTTO_NUMBER);
	}

	public LottoRunner(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public LottoResults run(WinningNumber winningNumber) {
		LottoResults results = new LottoResults();
		for(LottoNumber lottoNumber : lottoNumbers) {
			results.addResult(winningNumber.match(lottoNumber));
		}
		return results;
	}

	private List<LottoNumber> generateNumbers(int amount) {
		List<LottoNumber> numbers = new ArrayList<>();
		for(int i = 0; i < amount; i++) {
			numbers.add(LottoNumberAutoGenerator.generate());
		}
		return numbers;
	}

	public int getLottoNumbersSize() {
		return this.lottoNumbers.size();
	}
}
