package lotto;

import common.ExpressionParser;
import lotto.view.domain.LotteryStore;
import lotto.view.domain.LottoWallet;
import lotto.view.domain.ResultReport;
import lotto.view.domain.TicketMachine;
import lotto.view.in.InputDialog;
import lotto.view.out.ResultViewer;
import lotto.view.out.WalletViewer;
import common.NumberElementCollection;

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
		NumberElementCollection numbers = ExpressionParser
				.parse(input.execute("지난 주 당첨 번호를 입력해 주세요."));

		int investment = wallet.ticketCount() * LotteryStore.PRICE_OF_TICKET; // 투자금 (티켓구입액)
		ResultReport result = wallet.result(numbers);

		viewer.render(result, investment);
	}
}
