package lotto.view.out;

import lotto.LottoResult;
import lotto.ResultReport;

public class ResultViewer {
	MessagePrinter printer;

	public ResultViewer(MessagePrinter printer) {
		this.printer = printer;
	}

	/**
	 * 당첨결과 통계, 수익률 출력
	 * @param result
	 * @param investment	투자금 총액
	 */
	public void render(ResultReport result, int investment) {
		this.printer.print("당첨통계");
		this.printer.print("------");

		float rate = result.totalReward() / investment;
		this.printer.print(String.format("%s (%d원)- %d개", LottoResult.WIN_4TH.getCondition(), LottoResult.WIN_4TH.getReward(), result.countOfResult(LottoResult.WIN_4TH)));
		this.printer.print(String.format("총 수익률은 %.2f입니다.", rate));
	}
}
