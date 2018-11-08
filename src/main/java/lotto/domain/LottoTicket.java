package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicket {
	private List<Integer> lottoNumbers;

	private LottoTicket(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		LottoNumberValidator.valid(this);
	}

	public static LottoTicket newInstanceByAutomation(LottoMachine lottoMachine) {
		List<Integer> lottoNumbers = lottoMachine.drawLottoNumbers();
		return new LottoTicket(lottoNumbers);
	}

	public static LottoTicket newInstanceByManual(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		return new LottoTicket(lottoNumbers);
	}

	public int getMatchingCount(LottoTicket lottoTicket) {
		int matchingCount = 0;
		for (Integer number : lottoTicket.getNumbers()) {
			matchingCount += getNumbers().contains(number) ? 1 : 0;
		}
		return matchingCount;
	}

	public boolean hasNumber(Integer number) {
		return getNumbers().contains(number);
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(lottoNumbers);
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
