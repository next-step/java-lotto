package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
	private List<Lotto> lottoTicket;

	public List<Lotto> getLottoTicket() {
		return lottoTicket;
	}

	public LottoTicket generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		lottoTicket = new ArrayList<>();
		for (int i = 0; i < lottoGameCount; i++) {
			Lotto lottoNumber = new Lotto(numberGenerator.generateNumbers());
			lottoTicket.add(lottoNumber);
		}
		return this;
	}
}
