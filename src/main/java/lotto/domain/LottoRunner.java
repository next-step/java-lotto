package lotto.domain;

public class LottoRunner {

	private final long payment;
	private LottoNumbers lottoNumbers;
	private LottoMatchResults lottoMatchResults;

	private static final int PRICE_PER_LOTTO_NUMBER = 1000;

	public LottoRunner(long payment, LottoNumbers manualNumbers) {
		this.payment = payment;
		this.lottoNumbers = this.generateNumbers(manualNumbers);
	}

	private LottoNumbers generateNumbers(LottoNumbers manualNumbers) {
		LottoNumbers autoNumbers = LottoNumbersGenerator.generate(autoGenerableAmount(manualNumbers));
		return manualNumbers.addNumbers(autoNumbers);
	}

	public void match(WinningNumber winningNumber) {
		this.lottoMatchResults = this.lottoNumbers.match(winningNumber);
	}

	public LottoMatchResults getMatchResult() {
		return this.lottoMatchResults;
	}

	public double getEarningRate() {
		return (double) this.lottoMatchResults.getTotalEarnings() / this.payment;
	}

	public long autoGenerableAmount(LottoNumbers manualNumbers) {
		return this.payment / PRICE_PER_LOTTO_NUMBER - manualNumbers.getLottoNumbersSize();
	}

	public LottoNumbers autoLottoNumbers() {
		return this.lottoNumbers.getAutoLottoNumbers();
	}

	public long totalLottoNumberAmount() {
		return this.lottoNumbers.getLottoNumbersSize();
	}
}
