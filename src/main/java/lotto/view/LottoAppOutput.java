package lotto.view;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.LottoNumbersGroup;

public class LottoAppOutput {
	private static final String LOTTO_NUMBER_OUTPUT_DELIMITER = ", ";

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

	public void printLottoNumbersGroup(LottoNumbersGroup lottoNumbersGroup) {
		for (List<Integer> lottoNumbers : lottoNumbersGroup.getLottoNumbersGroup()) {
			printLottoNumbers(lottoNumbers);
		}
		printStream.println();
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
}
