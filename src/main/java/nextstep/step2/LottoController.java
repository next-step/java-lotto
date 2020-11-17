package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.LottoResultView;
import nextstep.step2.view.LottoTicketView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

	public List<Lotto> startLottoGameGetLottos(LottoPurchase purchase, LottoResultView resultView) {
		resultView.printLottoPurchase(purchase.getLottoCount());
		return printAutoLottoTicketsAndLottos(purchase);
	}

	public void printLottoStaticsic(String winnerNumbers, LottoPurchase purchase, List<Lotto> lottoList, LottoResultView resultView) {
		LottoStaticstic lottoStaticstic = new LottoStaticstic(winnerNumbers, purchase);
		Map<LottoReward, List<WinningLotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(lottoList);
		resultView.printLottoStaticsic(lottoRewardListMap);
		resultView.printWinningProbability(lottoStaticstic.calculateWinningProbability(lottoRewardListMap));
	}

	private List<Lotto> printAutoLottoTicketsAndLottos(LottoPurchase purchase) {
		int lottoCount = purchase.getLottoCount();
		List<Lotto> lottoList = purchaseLottos(lottoCount);
		LottoTicketView lottoTicketView = new LottoTicketView();
		lottoTicketView.printLottoTickets(lottoList);
		return lottoList;
	}

	private List<Lotto> purchaseLottos(int lottoCount) {
		LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
		List<Lotto> lottos = new ArrayList<>(lottoCount);
		for(int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(lottoAutoGenerator.getAutoNumbers()));
		}
		return lottos;
	}
}
