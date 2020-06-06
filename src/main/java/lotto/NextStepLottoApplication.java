package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.collections.LottoResult;
import lotto.collections.LottoTicket;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;
import lotto.collections.WinningTicket;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.service.PurchaseService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class NextStepLottoApplication {

	public static void main(String[] args) {
		Money money = InputView.inputPurchaseMoney();
		LottoTickets userManualTicket = getUserManualTicket();
		LottoTickets manualAndAutoTickets = PurchaseService.purchaseAutoDrawnTickets(money, userManualTicket);
		OutputView.printNumberOfPurchasedTickets(userManualTicket, manualAndAutoTickets);

		WinningNumbers winningNumbers = InputView.inputLastWeekWinningNumbers();
		LottoNumber bonusBall = InputView.inputBonusBall();
		WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusBall);

		LottoResult lottoResult = WinningService.getLottoResult(manualAndAutoTickets, winningTicket);
		OutputView.printResult(lottoResult, manualAndAutoTickets);
	}

	private static LottoTickets getUserManualTicket() {
		int numberOfManualTickets = InputView.inputNumberOfManuallyDrawnTickets();
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		for (int index = 0; index < numberOfManualTickets; index++) {
			List<Integer> pickedValues = InputView.inputManuallyDrawnTickets();
			lottoTicketList.add(PurchaseService.drawUserPickedTicket(pickedValues));
		}
		return new LottoTickets(lottoTicketList);
	}
}
