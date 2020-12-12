package lotto;

public class LottoRunner {

	private static final int PRICE_PER_LOTTO_NUMBER = 1000;

	private LottoRunner() {
		throw new AssertionError();
	}

	public static LottoMatchResults run(int payment, WinningNumber winningNumber) {
		LottoMatchResults results = new LottoMatchResults(payment);
		return LottoNumbersGenerator.generate(lottoTotalAmount(payment))
			.match(results, winningNumber);
	}

	public static int lottoTotalAmount(int payment) {
		return payment / PRICE_PER_LOTTO_NUMBER;
	}
}
