package lotto.view.out;

public class ResultViewer {
	MessagePrinter printer;

	public ResultViewer(MessagePrinter printer) {
		this.printer = printer;
	}

	public void render() {
		this.printer.print("당첨통계");
		this.printer.print(String.format("총 수익률은 %.2f입니다.", 5f));
	}
}
