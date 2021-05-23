package lotto;

import lotto.domain.LottoReport;
import lotto.domain.UserLotto;

public class LottoController {

	private final LottoService lottoService = new LottoService();

	public UserLotto buyLotto(String money) {
		return lottoService.buyLotto(money);
	}

	public LottoReport report(String winningLottoNumbers, UserLotto userLotto) {
		return lottoService.report(winningLottoNumbers, userLotto);
	}

}
