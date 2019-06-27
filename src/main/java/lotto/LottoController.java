package lotto;

import lotto.view.in.InputDialog;
import lotto.view.out.WalletViewer;

public class LottoController {

	protected LottoWallet wallet;

	protected LotteryStore store;

	public LottoController(){
		this.store = new LotteryStore();
	}

	public void invest(InputDialog input, WalletViewer viewer){
		int investment = Integer.parseInt(input.execute("구입금액을 입력해 주세요."));
		this.wallet = store.buy(investment);

		viewer.render(wallet);
	}
}
