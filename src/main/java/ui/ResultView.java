package ui;

import exception.LottoException;
import lotto.LottoNumbersFactory;
import lotto.LottoResult;
import utils.ConsoleUtils;

import java.math.BigDecimal;

import static type.MessageType.*;

public class ResultView {

	private ResultView() {
		// empty
	}

	public static void printExceptionMessage(LottoException lottoException) {
		ConsoleUtils.printLine(lottoException.getMessage());
	}

	public static void printMessage(final String message) {
		ConsoleUtils.printLine(message);
	}

	public static void printMessageWithoutLine(final String message) {
		ConsoleUtils.print(message);
	}

	public static void printLine() {
		ConsoleUtils.printLine();
	}


	public static void printResultBuyLotto(final LottoNumbersFactory lottoNumbersFactory) {
		if (lottoNumbersFactory == null) {
			return;
		}
		printMessage(makeLottoSizeMessage(lottoNumbersFactory.size()));
		printMessage(lottoNumbersFactory.toString());
		printLine();
	}

	private static String makeLottoSizeMessage(final int size) {
		return new StringBuilder()
			.append(size)
			.append(OUTPUT_LOTTO_COUNT.message())
			.toString();
	}

	public static void printWinningLottoNumber() {
		ResultView.printLine();
		ResultView.printMessage(OUTPUT_RESULT.message());
	}

	public static void printCalculateRevenue(final LottoResult lottoResult, final BigDecimal revenue) {
		ResultView.printMessage(lottoResult.toString());
		printMessageWithoutLine(makeLottoRevenueMessage(revenue));
		if (revenue.compareTo(BigDecimal.ZERO) < 1) {
			ResultView.printMessage(OUTPUT_FAILED_LOTTO_REVENUE.message());
		}
	}

	private static String makeLottoRevenueMessage(final BigDecimal revenue) {
		return String.format(OUTPUT_LOTTO_REVENUE.message(), revenue);
	}
}
