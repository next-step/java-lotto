package lotto.view;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.LottoTicket;
import lotto.view.dto.LottoEarningRateDto;
import lotto.view.dto.LottoRankResultDto;
import lotto.view.dto.LottoResultDto;

public class LottoAppOutput {
	private static final String LOTTO_NUMBER_OUTPUT_DELIMITER = ", ";

	private final PrintStream printStream;

	public LottoAppOutput(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void printMoneyInputView() {
		printStream.println("구매금액을 입력해 주세요.");
	}

	public void printBoughtLottoNumbersCountView(int lottoNumbersCount) {
		printStream.println(lottoNumbersCount + "개를 구매했습니다.");
	}

	public void printLottoTicket(LottoTicket lottoTicket, int manualCount, int autoCount) {
		printNewLine();
		String render = String.format("수동으로 %s개, 자동으로 %s개를 구매했습니다.", manualCount, autoCount);
		printStream.println(render);
		for (List<Integer> lottoNumbers : lottoTicket.getLottoNumbersGroup()) {
			printLottoNumbers(lottoNumbers);
		}
		printNewLine();
	}

	void printLottoNumbers(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		String lottoNumberText = renderLottoNumbers(lottoNumbers);
		printStream.println("[" + lottoNumberText + "]");
	}

	private String renderLottoNumbers(List<Integer> lottoNumbers) {
		return lottoNumbers.stream()
			.map(String::valueOf)
			.collect(Collectors.joining(LOTTO_NUMBER_OUTPUT_DELIMITER));
	}

	public void printWinningNumbersInputView() {
		printStream.println("지난 주 당첨 번호를 입력해 주세요.");
	}

	public void printLottoResult(LottoResultDto lottoResultDto) {
		printNewLine();
		printStream.println("당첨 통계");
		printStream.println("---------");
		for (LottoRankResultDto lottoRankResultDto : lottoResultDto.getLottoRankResultDtos()) {
			printLottoRankResult(lottoRankResultDto);
		}
		printLottoEarningsRate(lottoResultDto.getLottoEarningRateDto());
	}

	void printLottoRankResult(LottoRankResultDto lottoRankResultDto) {
		String render = String.format("%s개 일치%s (%s원)- %s개", lottoRankResultDto.getCountOfMatch(),
			lottoRankResultDto.isMatchBonusBall() ? ", 보너스 볼 일치" : "",
			lottoRankResultDto.getPrize(),
			lottoRankResultDto.getResultCount());
		printStream.println(render);
	}

	private void printNewLine() {
		printStream.println();
	}

	public void printLottoEarningsRate(LottoEarningRateDto lottoEarningRateDto) {
		String profitOrLoss = lottoEarningRateDto.isProfit() ? "이익이라는" : "손해라는";
		String render = String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s 의미임)",
			lottoEarningRateDto.getEarningsRate(),
			profitOrLoss);
		printStream.println(render);
	}

	public void printBonusNumberInputView() {
		printStream.println("보너스 볼을 입력해 주세요.");
	}

	public void printManualCountInputView() {
		printNewLine();
		printStream.println("수동으로 구매할 로또 수를 입력해 주세요.");
	}

	public void printManualLottoNumbersInputView() {
		printNewLine();
		printStream.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public void printMessage(String message) {
		printStream.println(message);
		printNewLine();
	}
}
