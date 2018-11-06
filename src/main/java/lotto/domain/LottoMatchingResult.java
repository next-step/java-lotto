package lotto.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoMatchingResult {
	private Map<LottoWinnerType, List<LottoTicket>> lottoWinnerTypeListMap;

	public List<LottoTicket> getFirstWinners() {
		return lottoWinnerTypeListMap.get(LottoWinnerType.FIRST_WINNER);
	}
}
