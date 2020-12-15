package lotto.domain;

public class LottoRunner {

	private AutoLottoNumbers autoLottoNumbers;
	private ManualLottoNumbers manualLottoNumbers;
	private LottoMatchResults lottoMatchResults;

	private static final int PRICE_PER_LOTTO_NUMBER = 1000;

	public LottoRunner(long payment, ManualLottoNumbers manualNumbers) {
		this.lottoMatchResults = new LottoMatchResults(payment);
		this.manualLottoNumbers = manualNumbers;
		this.autoLottoNumbers = LottoNumbersGenerator.generate(autoAmountWithManual(payment, manualNumbers));
	}

	public LottoMatchResults match(WinningNumber winningNumber) {
		this.manualLottoNumbers.match(this.lottoMatchResults, winningNumber);
		this.autoLottoNumbers.match(this.lottoMatchResults, winningNumber);
		return this.lottoMatchResults;
	}

	public long autoAmountWithManual(long payment, ManualLottoNumbers manualLottoSize) {
		return payment / PRICE_PER_LOTTO_NUMBER - manualLottoSize.getLottoNumbersSize();
	}
	public long totalAmount() {
		return this.autoLottoNumbers.getLottoNumbersSize() + this.manualLottoNumbers.getLottoNumbersSize();
	}

	public AutoLottoNumbers getAutoLottoNumbers() {
		return this.autoLottoNumbers;
	}
}
