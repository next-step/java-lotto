package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket {

	private final List<LottoNumber> lottoNumbers;
	private final LottoNumber bonusNumber;

	public WinningLottoTicket(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
		this.lottoNumbers = lottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLottoTicket from(List<Integer> winningNumbers, int bonusNumber) {
		validateNumbers(winningNumbers, bonusNumber);
		List<LottoNumber> lottoNumbers = winningNumbers.stream()
											.map(LottoNumber::new)
											.collect(Collectors.toList());
		return new WinningLottoTicket(lottoNumbers, new LottoNumber(bonusNumber));
	}

	private static void validateNumbers(List<Integer> winningNumbers, int bonusNumber) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException();
		}
	}

}
