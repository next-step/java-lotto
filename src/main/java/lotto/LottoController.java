package lotto;

import common.ExpressionSplitter;
import lotto.domain.LotteryStore;
import lotto.domain.LottoWallet;
import lotto.domain.ResultReport;
import lotto.domain.TicketMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberSet;
import lotto.model.WinNumber;
import lotto.view.in.InputDialog;
import lotto.view.out.ResultViewer;
import lotto.view.out.WalletViewer;

public class LottoController {

	protected LottoWallet wallet;

	protected LotteryStore store;

	public LottoController(){
		this(new TicketMachine());
	}

	public LottoController(TicketMachine machine){
		this.store = new LotteryStore(machine);
	}

	public void invest(InputDialog input, WalletViewer viewer){
		int investment = Integer.parseInt(input.execute("구입금액을 입력해 주세요."));
		this.wallet = store.buy(investment);

		viewer.render(wallet);
	}

	public void lottery(InputDialog input, ResultViewer viewer) {
		String inputValue = input.execute("지난 주 당첨 번호를 입력해 주세요.");
		LottoNumberSet numbers = LottoNumberSet.of(new ExpressionSplitter(inputValue).split());

		LottoNumber bonusNumber = new LottoNumber(input.execute("보너스 볼을 입력해 주세요."));
		WinNumber winNumber = new WinNumber(numbers, bonusNumber);

		ResultReport result = wallet.result(winNumber);
		int investment = wallet.ticketCount() * LotteryStore.PRICE_OF_TICKET; // 투자금 (티켓구입액)

		viewer.render(result, investment);
	}
}
