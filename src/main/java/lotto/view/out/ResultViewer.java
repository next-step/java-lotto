package lotto.view.out;

public class ResultViewer {
	MessagePrinter printer;

	public ResultViewer(MessagePrinter printer) {
		this.printer = printer;
	}

	public void render() {
		this.printer.print("당첨통계");
	}
}
