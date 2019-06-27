package lotto.view.out;

import lotto.LottoWallet;

public class WalletViewer {

	MessagePrinter printer;

	public WalletViewer(MessagePrinter printer) {
		this.printer = printer;
	}

	public void render(LottoWallet wallet) {
		printer.print(wallet.ticketCount() + "개를 구매했습니다.");
		printer.print(wallet.toString());
	}
}
