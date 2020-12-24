package lotto.modal;

public class WinnerLotto {

	private final Lotto winner;
	private final LottoNumber bonusNumber;

	private WinnerLotto(final Lotto winnerLotto, final LottoNumber bonusNumber) {

		this.winner = winnerLotto;
		this.bonusNumber = bonusNumber;
	}

	public static WinnerLotto generateWinner(Lotto winnerLotto, LottoNumber bonusNumber) {
		validationWinnerLotto(winnerLotto, bonusNumber);
		return new WinnerLotto(winnerLotto, bonusNumber);
	}

	public int getMatchCount(Lotto compareLotto) {
		return compareLotto.getLotto().stream()
			.mapToInt(this::isContain)
			.sum();
	}

	public int isContain(LottoNumber number) {
		if (this.winner.getLotto().contains(number)) {
			return 1;
		}
		return 0;
	}

	public boolean isContainBonus(Lotto lotto) {
		return lotto.getLotto().contains(bonusNumber);
	}

	private static void validationWinnerLotto(Lotto winnerLotto, LottoNumber bonusNumber) {

		if (winnerLotto == null || bonusNumber == null) {
			throw new IllegalArgumentException("당첨번호 or 보너스 번호가 잘못 입력되었습니다.");
		}

		if (winnerLotto.isContainNumber(bonusNumber)) {
			throw new IllegalArgumentException("당첨번호와 중복된 보너스 번호를 입력햐였습니다.");
		}
	}

}
