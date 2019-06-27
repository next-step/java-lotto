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
	 * @param report
	 * @param investment	투자금 총액
	 */
	public void render(ResultReport report, int investment) {

		this.printer.print("");
		this.printer.print("당첨통계");
		this.printer.print("------");

		for(LottoResult result : LottoResult.winResults()){
			this.printer.print(String.format("%s (%d원)- %d개",
					result.getCondition(),
					result.getReward(),
					report.countOfResult(result)));
		}

		float rate = report.totalReward() / investment;
		this.printer.print(String.format("총 수익률은 %.2f입니다.", rate));
	}
}
