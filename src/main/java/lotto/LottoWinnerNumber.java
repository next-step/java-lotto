package lotto;

public class LottoWinnerNumber {
	private final LottoNumbers winnerNumber;

	public LottoWinnerNumber(LottoNumbers winnerNumber) {
		this.winnerNumber = winnerNumber;
	}

	public LottoResult matchesResult(LottoNumbers targetNumbers) {
		int count = Math.toIntExact(targetNumbers.getNumbers().stream().filter(this::isContainsLottoNumber).count());
		return new LottoResult(count);
	}

	public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
		return this.winnerNumber.getNumbers().contains(lottoNumber);
	}
}
