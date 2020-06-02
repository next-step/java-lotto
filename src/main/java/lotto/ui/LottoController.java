package lotto.ui;

import lotto.application.LottoIssueRequest;
import lotto.application.LottoIssueResponse;
import lotto.application.LottoMachine;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;

public class LottoController {

	private final LottoMachine machine;

	public LottoController(LottoMachine machine) {
		this.machine = machine;
	}

	public LottoIssueResponse issueLottos() {
		LottoIssueRequest lottoIssueRequest = new LottoIssueRequest(InputView.getPaid(), InputView.askManualNumbers());
		LottoIssueResponse lottoIssueResponse = machine.issue(lottoIssueRequest);
		ResultView.printLottos(lottoIssueResponse);
		return lottoIssueResponse;
	}

	public void rankLottos(Lottos lottos) {
		LottoResults results = lottos.checkResults(InputView.askWinningNumbers(), InputView.askBonusNumber());
		ResultView.printResults(results);
	}
}
