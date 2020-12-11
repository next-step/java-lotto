package lotto;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LottoTicket extends ArrayList<LottoNumbers> {

	public LottoResults resultOfWinnerNumber(LottoWinnerNumber winningNumber) {
		return new LottoResults(this.stream()
			.map(winningNumber::matchesResult)
			.collect(Collectors.toList()));
	}
}
