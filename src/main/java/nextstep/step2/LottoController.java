package nextstep.step2;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoAutoGenerator;
import nextstep.step2.domain.LottoPurchase;
import nextstep.step2.domain.LottoStaticstic;
import nextstep.step2.view.LottoResultView;
import nextstep.step2.view.LottoTicketView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
	public List<Lotto> startLottoGameGetLottos(int money) {
		LottoPurchase purchase = new LottoPurchase(money);
		return printAutoLottoTicketsAndLottos(purchase);
	}

	public void printLottoStaticsic(String winnerNumbers, List<Lotto> lottoList) {
		LottoStaticstic lottoPercentage = new LottoStaticstic(winnerNumbers);
		LottoResultView resultView = new LottoResultView();
		resultView.printLottoStaticsic(lottoPercentage.getLottoRewardMap(lottoList));
	}

	private List<Lotto> printAutoLottoTicketsAndLottos(LottoPurchase purchase) {
		int lottoCount = purchase.getLottoCount();
		List<Lotto> lottoList = purchaseLottos(lottoCount);
		LottoTicketView lottoTicketView = new LottoTicketView(lottoList);
		lottoTicketView.printLottoTickets();
		return lottoList;
	}

	private List<Lotto> purchaseLottos(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>(lottoCount);
		for(int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(new LottoAutoGenerator()));
		}
		return lottos;
	}
}
