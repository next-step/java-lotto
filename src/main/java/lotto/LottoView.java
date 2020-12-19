package lotto;

import lotto.result.LottoStatistics;

public interface LottoView {
	void showLottoTicket(LottoTicket lottoTicket);

	void showStatistics(LottoStatistics lottoStatistics);
}
