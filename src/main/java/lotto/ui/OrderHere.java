package lotto.ui;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.PrizeInfo;
import lotto.domain.PurchaseStandBy;
import lotto.ui.input.InputChannel;
import lotto.ui.output.OutputChannel;

import java.util.Optional;
import java.util.function.Supplier;

import static lotto.constants.MessageConstant.*;
import static lotto.utils.StringUtils.splitByDelimiter;

public class OrderHere {

	private final InputChannel inputChannel;
	private final OutputChannel outputChannel;

	public OrderHere() {
		this.inputChannel = InputChannel.getSystemInChannel();
		this.outputChannel = OutputChannel.getSystemOutChannel();
	}

	public PurchaseStandBy orderNewPurchasing() {
		return new PurchaseStandBy(retryUntilGettingRightValue(getPurchasingPrice()));
	}

	public PrizeInfo receiveLastWeekPrize() {
		LottoGame prizeLottoGame = new LottoGame(retryUntilGettingRightValue(getPrizeNumbers()));
		LottoNumber bonusNumber = new LottoNumber(retryUntilGettingRightValue(getBonusNumber()));
		return new PrizeInfo(prizeLottoGame, bonusNumber);
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
		String input = inputChannel.getStringValue();
		return splitByDelimiter(input);
	}
}
