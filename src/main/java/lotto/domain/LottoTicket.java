package lotto.domain;

import lotto.domain.validator.LottoTicketValidator;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicket {
	private List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		LottoTicketValidator.valid(this);
	}

	public static LottoTicket newInstanceByAutomation(LottoMachine lottoMachine) {
		List<LottoNumber> lottoNumbers = lottoMachine.drawLottoNumbers();
		return new LottoTicket(lottoNumbers);
	}

	public static LottoTicket newInstanceByManual(List<LottoNumber> manualNumbers) {
		Collections.sort(manualNumbers);
		return new LottoTicket(manualNumbers);
	}

	public int getMatchingCount(LottoTicket lottoTicket) {
		int matchingCount = 0;
		for (LottoNumber number : lottoTicket.getNumbers()) {
			matchingCount += getNumbers().contains(number) ? 1 : 0;
		}
		return matchingCount;
	}

	public boolean hasNumber(LottoNumber number) {
		return getNumbers().contains(number);
	}

	public List<LottoNumber> getNumbers() {
		return Collections.unmodifiableList(lottoNumbers);
	}

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
		for (LottoNumber lottoNumber : lottoNumbers) {
			stringJoiner.add(lottoNumber.toString());
		}
		return stringJoiner.toString();
	}
}
