package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;

	public int calculateLottoCount(int input) {
		validateInput(input);
		return input / LOTTO_PRICE;
	}

	private void validateInput(int input) {
		if (input < LOTTO_PRICE) {
			throw new IllegalArgumentException(LOTTO_PRICE + "원 이상 입력 가능합니다.");
		}
	}

	public LottoTicket generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		return new LottoTicket(lottoGameCount, numberGenerator);
	}

	public Map<LottoRank, Long> generateLottoGameResult(WinLotto winLotto, LottoTicket lottoTicket) {
		return lottoTicket.getLottoTicket().stream()
			.map(lottoNumber -> lottoNumber.rankLotto(winLotto))
			.collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));
	}

	public void validateInput(int lottoTotalCount, int lottoManualCount) {
		if (lottoManualCount > lottoTotalCount) {
			throw new IllegalArgumentException("총 로또구매개수보다 많습니다. (총 로또구매개수 : " + lottoTotalCount + ", 수동 로또구매개수 : " + lottoManualCount);
		}
	}
}
