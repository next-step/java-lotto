package lotto.domain;

public class WinningLotto {

	private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	private final LottoTicket winningLottoTicket;
	private final LottoNumber bonusLottoNumber;

	public WinningLotto(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
		validateBonusNumber(winningLottoTicket, bonusLottoNumber);

		this.winningLottoTicket = winningLottoTicket;
		this.bonusLottoNumber = bonusLottoNumber;
	}

	private void validateBonusNumber(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
		if (winningLottoTicket.isMatchingNumber(bonusLottoNumber)) {
			throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE);
		}
	}

	public LottoRank rank(LottoTicket userLottoTicket) {
		return LottoRank.rank(countMatchingNumber(userLottoTicket), isMatchingBonusNumber(userLottoTicket));
	}

	private boolean isMatchingBonusNumber(LottoTicket userLottoTicket) {
		return userLottoTicket.isMatchingNumber(bonusLottoNumber);
	}

	private int countMatchingNumber(LottoTicket userLottoTicket) {
		return LottoTicket.countMatchingNumber(userLottoTicket, winningLottoTicket);
	}
}
