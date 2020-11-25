package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.LottoResultView;
import nextstep.step2.view.LottoTicketView;

import java.util.List;
import java.util.Map;

public class LottoController {

	public Lottos startLottoGameGetLottos(LottoCount lottoCount, String manaulLottos, LottoResultView resultView) {
		resultView.printLottoPurchase(lottoCount);
		return printLottoListAndReturnLottos(lottoCount, manaulLottos);
	}

	public void printLottoStaticsic(LottoStaticstic lottoStaticstic, Lottos lottos, LottoResultView resultView) {
		Map<LottoReward, List<Lotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(lottos);
		resultView.printLottoStaticsic(lottoRewardListMap);
		resultView.printWinningProbability(lottoStaticstic.calculateWinningProbability(lottoRewardListMap));
	}

	private Lottos printLottoListAndReturnLottos(LottoCount lottoCount, String manaulLottos) {
		Lottos purchaseLottos = Lottos.mergeLottos(manaulLottos, lottoCount.getAuto());
		LottoTicketView.printLottoTickets(purchaseLottos);
		return purchaseLottos;
	}
}
