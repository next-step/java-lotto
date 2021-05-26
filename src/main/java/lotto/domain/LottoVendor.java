package lotto.domain;

import static lotto.util.ValidationUtils.*;

public class LottoVendor {

	private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	private final LottoTicket winningLottoTicket;
	private final LottoNumber bonusNumber;

	public LottoVendor(String winningLottoNumbers, String bonusNumberString) {
		validateNumber(bonusNumberString);

		LottoTicket lottoTicket = LottoTicketConverter.convert(winningLottoNumbers);
		LottoNumber lottoNumber = LottoNumber.of(Integer.parseInt(bonusNumberString));

		validateIntersectWinningNumber(lottoTicket, lottoNumber);

		winningLottoTicket = lottoTicket;
		bonusNumber = lottoNumber;
	}

	private void validateIntersectWinningNumber(LottoTicket lottoTicket, LottoNumber lottoNumber) {
		if (lottoTicket.matchNumber(lottoNumber)) {
			throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE);
		}
	}

	public LottoReport report(UserLotto userLotto) {
		return userLotto.report(winningLottoTicket, bonusNumber);
	}

}
