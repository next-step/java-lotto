package lotto.view;

import java.io.PrintStream;

public class LottoAppOutput {

	private final PrintStream printStream;

	public LottoAppOutput(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void printMoneyInputView() {
		printStream.println("구매금액을 입력해 주세요.");
	}

	public void printBoughtLottoCountView(int lottoCount) {
		printStream.println(lottoCount + "개를 구매했습니다.");
	}
}
