package ui;

import exception.LottoException;
import lotto.LottoNumbers;
import lotto.LottoNumbersFactory;
import lotto.LottoResult;
import type.LottoRewardType;
import utils.ConsoleUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

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
		printMessage(convertStringToLottoNumbersFactory(lottoNumbersFactory));
		printLine();
	}

	private static String makeLottoSizeMessage(final int size) {
		return new StringBuilder()
			.append(size)
			.append(OUTPUT_LOTTO_COUNT.message())
			.toString();
	}

	private static String convertStringToLottoNumbersFactory(final LottoNumbersFactory lottoNumbersFactory) {
		return lottoNumbersFactory.lottoList().stream()
								  .map(lottoNumbers -> lottoNumbers.lottoNumbers().toString())
								  .collect(Collectors.joining("\n"));
	}


	public static void printWinningLottoNumber() {
		ResultView.printLine();
		ResultView.printMessage(OUTPUT_RESULT.message());
	}

	public static void printCalculateRevenue(final LottoResult lottoResult, final BigDecimal revenue) {
		ResultView.printMessage(convertStringToLottoResult(lottoResult));
		printMessageWithoutLine(makeLottoRevenueMessage(revenue));
		if (revenue.compareTo(BigDecimal.ZERO) < 1) {
			ResultView.printMessage(OUTPUT_FAILED_LOTTO_REVENUE.message());
		}
	}

	private static String convertStringToLottoResult(final LottoResult lottoResult) {
		return lottoResult.lottoRewardMap().entrySet()
						  .stream()
						  .filter(entry -> entry.getKey() != LottoRewardType.NONE)
						  .map(ResultView::makeLottoRewardMessage)
						  .collect(Collectors.joining(System.lineSeparator()));
	}

	private static String makeLottoRewardMessage(Map.Entry<LottoRewardType, Integer> entry) {
		return new StringBuilder()
			.append(entry.getKey().message())
			.append("- ")
			.append(entry.getValue())
			.append("개")
			.toString();
	}

	private static String makeLottoRevenueMessage(final BigDecimal revenue) {
		return String.format(OUTPUT_LOTTO_REVENUE.message(), revenue);
	}
}
