package lotto;

import common.ExpressionSplitter;
import lotto.domain.LotteryStore;
import lotto.domain.LottoWallet;
import lotto.domain.ResultReport;
import lotto.domain.TicketMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberSet;
import lotto.model.WinNumber;
import lotto.view.in.OrderInputDialog;
import lotto.view.in.SingleInputDialog;
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

	/**
	 * 주문서입력기, 주문결과(로또지갑)뷰어 주입 투자(구매)단계 진행 메서드
	 * @param orderDialog 주문서 입력기
	 * @param viewer 주문결과 조회뷰
	 */
	public void invest(OrderInputDialog orderDialog, WalletViewer viewer){
		this.wallet = store.buy(orderDialog.makeOrder());
		viewer.render(wallet);
	}

	/**
	 * 단일갑 입력대화창, 결과조회를 주입해서 당첨결과 단계를 진행하는 메서드
	 * @param input
	 * @param viewer
	 */
	public void lottery(SingleInputDialog input, ResultViewer viewer) {
		String inputValue = input.execute("지난 주 당첨 번호를 입력해 주세요.");
		LottoNumberSet numbers = LottoNumberSet.of(new ExpressionSplitter(inputValue).split());

		LottoNumber bonusNumber = new LottoNumber(input.execute("보너스 볼을 입력해 주세요."));
		WinNumber winNumber = new WinNumber(numbers, bonusNumber);

		ResultReport result = wallet.result(winNumber);
		int investment = wallet.ticketCount() * LotteryStore.PRICE_OF_TICKET; // 투자금 (티켓구입액)

		viewer.render(result, investment);
	}

}
