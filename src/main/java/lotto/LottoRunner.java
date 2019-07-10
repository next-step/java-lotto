package lotto;

import lotto.view.in.ConsoleDialog;
import lotto.view.in.ConsoleReader;
import lotto.view.in.InputReader;
import lotto.view.in.OrderInputDialog;
import lotto.view.out.ConsolePrinter;
import lotto.view.out.MessagePrinter;
import lotto.view.out.ResultViewer;
import lotto.view.out.WalletViewer;

public class LottoRunner {

	public static void main(String args[]) {
		LottoController controller = new LottoController();
		MessagePrinter printer = new ConsolePrinter();
		InputReader consoleReader = new ConsoleReader();

		// 주문실행
		OrderInputDialog orderDialog = new OrderInputDialog(printer, consoleReader);
		controller.invest(orderDialog, new WalletViewer(printer));

		// 당첨결과 실행
		ConsoleDialog dialog = new ConsoleDialog();
		controller.lottery(dialog, new ResultViewer(printer));
	}
}
