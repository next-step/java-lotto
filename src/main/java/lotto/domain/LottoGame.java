package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;

	public int calculateLottoCount(int input) {
		if (input <= 0) {
			return 0;
		}
		return input/LOTTO_PRICE;
	}

	public LottoTicket generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		LottoTicket lottoNumbers = new LottoTicket();
		return lottoNumbers.generateLottoNumbers(lottoGameCount, numberGenerator);
	}

	public Map<LottoRank, Long> generateLottoGameResult(Lotto winLotto, LottoTicket lottoTicket) {
		return lottoTicket.getLottoTicket().stream()
			.map(lottoNumber -> lottoNumber.rankLotto(winLotto))
			.collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));
	}
}
