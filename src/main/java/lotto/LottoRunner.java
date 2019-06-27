package lotto;

import lotto.view.in.ConsoleDialog;
import lotto.view.in.InputDialog;
import lotto.view.out.ConsolePrinter;
import lotto.view.out.MessagePrinter;
import lotto.view.out.ResultViewer;
import lotto.view.out.WalletViewer;

public class LottoRunner {

	public static void main(String args[]) {

		InputDialog dialog = new ConsoleDialog();
		MessagePrinter printer = new ConsolePrinter();

		LottoController controller = new LottoController();
		controller.invest(dialog, new WalletViewer(printer));
		controller.lottery(dialog, new ResultViewer(printer));
	}
}
