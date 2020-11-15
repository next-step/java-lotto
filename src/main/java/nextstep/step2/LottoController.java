package nextstep.step2;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoAutoGenerator;
import nextstep.step2.domain.LottoPurchase;
import nextstep.step2.view.InputView;
import nextstep.step2.view.LottoTicketView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoController {
	public void startLottoGame() {
		InputView inputMoney = new InputView(new Scanner(System.in));
		LottoPurchase purchase = new LottoPurchase(inputMoney.getInputMessage());

		printAutoLottoTickets(purchase);

		InputView inputLastWinningNumbers = new InputView(new Scanner(System.in));
		inputLastWinningNumbers.getInputLottoWinningNumbers();
	}

	private void printAutoLottoTickets(LottoPurchase purchase) {
		int lottoCount = purchase.getLottoCount();
		LottoTicketView lottoTicketView = new LottoTicketView(purchaseLottos(lottoCount));
		lottoTicketView.printLottoTickets();
	}

	private List<Lotto> purchaseLottos(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>(lottoCount);
		for(int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(new LottoAutoGenerator()));
		}
		return lottos;
	}
}
