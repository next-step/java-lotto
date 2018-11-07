package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicket implements LottoNumber {
	private List<Integer> lottoNumbers;

	private LottoTicket(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoTicket newInstanceByAutomation(LottoMachine lottoMachine) {
		List<Integer> lottoNumbers = lottoMachine.drawLottoNumbers();
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
		LottoNumberValidator.valid(lottoTicket);
		return lottoTicket;
	}

	public static LottoTicket newInstanceByManual(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
		LottoNumberValidator.valid(lottoTicket);
		return lottoTicket;
	}

	public LottoWinnerType matchNumber(LottoNumber lottoNumber) {
		int matchingCount = getMatchingCount(lottoNumber);
		return LottoWinnerType.findByMatchingCountAndBonus(matchingCount, false);
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(lottoNumbers);
	}

	private void setLottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
		for (Integer lottoNumber : lottoNumbers) {
			stringJoiner.add(lottoNumber.toString());
		}
		return stringJoiner.toString();
	}
}
