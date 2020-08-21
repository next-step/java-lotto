package lotto.ui;

import lotto.domain.GameWinningCondition;
import lotto.domain.PurchaseStandBy;
import lotto.ui.input.InputChannel;
import lotto.ui.output.OutputChannel;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.MessageConstant.*;
import static lotto.utils.StringUtils.splitByDelimiter;

public class OrderHere {

	private static final int SEED = 0;
	private static final int INCREASE = 1;

	private final InputChannel inputChannel;
	private final OutputChannel outputChannel;

	public OrderHere() {
		this.inputChannel = InputChannel.getSystemInChannel();
		this.outputChannel = OutputChannel.getSystemOutChannel();
	}

	public PurchaseStandBy orderNewPurchasing() {
		Integer price = retryUntilGettingRightValue(getPurchasingPrice());
		Integer manualGameCount = retryUntilGettingRightValue(getManualGameCount());
		List<String[]> manualGameNumbers = retryUntilGettingRightValue(getManualGameNumbers(manualGameCount));
		return new PurchaseStandBy(price, manualGameNumbers);
	}

	public GameWinningCondition receiveLastWeekPrize() {
		String[] prizeNumbers = retryUntilGettingRightValue(getPrizeNumbers());
		Integer bonus = retryUntilGettingRightValue(getBonusNumber());
		return new GameWinningCondition(prizeNumbers, bonus);
	}

	private Supplier<Optional<Integer>> getPurchasingPrice() {
		return () -> Optional.ofNullable(sayQuestionAndGetInt(PLEASE_INPUT_PURCHASING_PRICE));

	}

	private Supplier<Optional<String[]>> getPrizeNumbers() {
		return () -> Optional.ofNullable(sayQuestionAndGetStringArray(PLEASE_INPUT_LAST_WEEK_PRIZE));
	}

	private Supplier<Optional<Integer>> getBonusNumber() {
		return () -> Optional.ofNullable(sayQuestionAndGetInt(PLEASE_INPUT_BONUS_NUMBER));
	}

	private Supplier<Optional<Integer>> getManualGameCount() {
		return () -> Optional.ofNullable(sayQuestionAndGetInt(PLEASE_INPUT_MANUAL_GAME_COUNT));
	}

	private Supplier<Optional<List<String[]>>> getManualGameNumbers(Integer count) {
		return () -> Optional.ofNullable(sayQuestionAndGetManualNumbersToLimit(PLEASE_INPUT_MANUAL_GAME_NUMBERS, count));
	}

	private <T> T retryUntilGettingRightValue(Supplier<Optional<T>> supplier) {
		Optional<T> result;

		do {
			result =  getSupplierValueOrElseNull(supplier);
		} while (result == Optional.empty());

		return result.get();
	}

	private <T> Optional<T> getSupplierValueOrElseNull(Supplier<Optional<T>> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			outputChannel.printLine(e.getMessage() + NEW_LINE);
			return Optional.empty();
		}
	}

	private Integer sayQuestionAndGetInt(String question) {
		outputChannel.printLine(question);
		return inputChannel.getIntValue();
	}

	private String[] sayQuestionAndGetStringArray(String question) {
		outputChannel.printLine(question);
		return getStringArray();
	}

	private String[] getStringArray() {
		String input = inputChannel.getStringValue();
		return splitByDelimiter(input);
	}

	private List<String[]> sayQuestionAndGetManualNumbersToLimit(String question, Integer limit) {
		outputChannel.printLine(question);
		return Stream.iterate(SEED, integer -> integer + INCREASE)
				.limit(limit)
				.map(integer -> getStringArray())
				.collect(Collectors.toList());
	}
}
