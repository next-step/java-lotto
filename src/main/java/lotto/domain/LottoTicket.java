package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicket {
	private List<Integer> lottoNumbers;

	public static LottoTicket newInstanceByAutomation(LottoMachine lottoMachine) {
		LottoTicket lottoTicket = new LottoTicket();
		List<Integer> lottoNumbers = lottoMachine.drawLottoNumbers();
		lottoTicket.setLottoNumbers(lottoNumbers);
		return lottoTicket;
	}

	public static LottoTicket newInstanceByManual(List<Integer> lottoNumbers) {
		LottoTicket lottoTicket = new LottoTicket();
		Collections.sort(lottoNumbers);
		lottoTicket.setLottoNumbers(lottoNumbers);
		return lottoTicket;
	}

	public LottoWinnerType matchNumber(LottoTicket targetTicket) {
		int matchingCount = 0;
		for (Integer winningNumber : targetTicket.lottoNumbers) {
			matchingCount += lottoNumbers.contains(winningNumber) ? 1 : 0;
		}
		return LottoWinnerType.findByMatchingCount(matchingCount);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
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
