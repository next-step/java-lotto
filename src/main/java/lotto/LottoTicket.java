package lotto;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LottoTicket extends ArrayList<LottoNumbers> {

	public LottoResults generateWinningResult(LottoNumbers winningNumber) {
		return new LottoResults(this.stream()
			.map(lottoNumbers -> lottoNumbers.isContainsCount(winningNumber))
			.map(LottoResult::new)
			.collect(Collectors.toList()));
	}
}
