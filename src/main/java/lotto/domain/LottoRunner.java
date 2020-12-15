package lotto.domain;

public class LottoRunner {

	private LottoNumbers autoLottoNumbers;
	private LottoNumbers manualLottoNumbers;
	private LottoMatchResults lottoMatchResults;

	private static final int PRICE_PER_LOTTO_NUMBER = 1000;

	public LottoRunner(long payment) {
		this.lottoMatchResults = new LottoMatchResults(payment);
		this.autoLottoNumbers = LottoNumbersGenerator.generate(autoAmountWithoutManual(payment));
	}

	public LottoRunner(long payment, LottoNumbers manualNumbers) {
		this.lottoMatchResults = new LottoMatchResults(payment);
		this.manualLottoNumbers = manualNumbers;
		this.autoLottoNumbers = LottoNumbersGenerator.generate(autoAmountWithManual(payment, manualNumbers));
	}

	public LottoMatchResults match(WinningNumber winningNumber) {
		return this.autoLottoNumbers.match(this.lottoMatchResults, winningNumber);
	}

	public long autoAmountWithoutManual(long payment) {
		return payment / PRICE_PER_LOTTO_NUMBER;
	}

	public long autoAmountWithManual(long payment, LottoNumbers manualLottoSize) {
		return payment / PRICE_PER_LOTTO_NUMBER - manualLottoSize.getLottoNumbersSize();
	}
	public long totalAmount() {
		return this.autoLottoNumbers.getLottoNumbersSize() + this.manualLottoNumbers.getLottoNumbersSize();
	}

	public LottoNumbers getAutoLottoNumbers() {
		return this.autoLottoNumbers;
	}
}
