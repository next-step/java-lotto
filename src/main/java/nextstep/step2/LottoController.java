package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.LottoResultView;
import nextstep.step2.view.LottoTicketView;

import java.util.List;
import java.util.Map;

public class LottoController {

	public Lottos startLottoGameGetLottos(LottoCount lottoCount, String manaulLottos) {
		LottoResultView.printLottoPurchase(lottoCount);
		Lottos purchaseLottos = Lottos.mergeLottos(manaulLottos, lottoCount.getAuto());
		LottoTicketView.printLottoTickets(purchaseLottos);
		return purchaseLottos;
	}

	public void printLottoStaticsic(LottoStaticstic lottoStaticstic, Lottos lottos) {
		Map<LottoReward, List<Lotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(lottos);
		LottoResultView.printLottoStaticsic(lottoRewardListMap);
		LottoResultView.printWinningProbability(lottoStaticstic.calculateWinningProbability(lottoRewardListMap));
	}
}
