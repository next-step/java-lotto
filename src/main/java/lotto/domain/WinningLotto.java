package lotto.domain;

import java.util.Optional;

public class WinningLotto {

	private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
	public static final String INVALID_BONUS_NUMBER_MESSAGE = "보너스 번호가 유효하지 않습니다.";

	private final LottoTicket winningLottoTicket;
	private final LottoNumber bonusLottoNumber;

	public WinningLotto(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
		this.bonusLottoNumber = validBonusNumber(bonusLottoNumber);
		this.winningLottoTicket = validLottoTicket(winningLottoTicket, bonusLottoNumber);
	}

	private LottoTicket validLottoTicket(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
		return Optional.ofNullable(winningLottoTicket)
			.filter(lottoTicket -> !lottoTicket.isMatchingNumber(bonusLottoNumber))
			.orElseThrow(() -> new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE));
	}

	private LottoNumber validBonusNumber(LottoNumber bonusLottoNumber) {
		return Optional.ofNullable(bonusLottoNumber)
			.orElseThrow(() -> new IllegalArgumentException(INVALID_BONUS_NUMBER_MESSAGE));
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
