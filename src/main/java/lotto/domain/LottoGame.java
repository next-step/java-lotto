package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoGameResultDto;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;

	private int lottoGameCount;

	public int calculateLottoCount(int input) {
		if (input <= 0) {
			return lottoGameCount = 0;
		}
		return lottoGameCount = input/LOTTO_PRICE;
	}

	public LottoTicket generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		LottoTicket lottoNumbers = new LottoTicket();
		return lottoNumbers.generateLottoNumbers(lottoGameCount, numberGenerator);
	}

	public LottoGameResultDto generateLottoGameResult(Lotto winLotto, LottoTicket lottoTicket) {
		Map<LottoRank, Long> lottoGameResult = lottoTicket.getLottoTicket().stream()
			.map(lottoNumber -> lottoNumber.rankLotto(winLotto))
			.collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));
		return new LottoGameResultDto(lottoGameResult, lottoGameCount);
	}
}
