package step2.ui;

import step2.PurchaseRequest;
import step2.domain.LottoGame;
import step2.ui.input.InputChannel;
import step2.ui.output.OutputChannel;

import java.util.function.Supplier;

import static com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text.NEW_LINE;
import static step2.constants.MessageConstant.PLEASE_INPUT_LAST_WEEK_PRIZE;
import static step2.constants.MessageConstant.PLEASE_INPUT_PURCHASING_PRICE;
import static step2.utils.StringUtils.splitByDelimiter;

public class OrderHere {

	private final InputChannel inputChannel;
	private final OutputChannel outputChannel;

	public OrderHere() {
		this.inputChannel = InputChannel.getDefaultChannel();
		this.outputChannel = OutputChannel.getDefaultChannel();
	}

	public PurchaseRequest purchaseLottoGame() {
		return new PurchaseRequest(retryUntilGettingRightValue(getPurchasingPrice()));
	}

	public LottoGame receiveLastWeekPrize() {
		return new LottoGame(retryUntilGettingRightValue(getPrizeNumbers()));
	}

	private Supplier<Integer> getPurchasingPrice() {
		return () -> sayQuestionAndGetInt(PLEASE_INPUT_PURCHASING_PRICE);

	}

	private Supplier<String[]> getPrizeNumbers() {
		return () -> sayQuestionAndGetStringArray(PLEASE_INPUT_LAST_WEEK_PRIZE);
	}

	private <T> T retryUntilGettingRightValue(Supplier<T> supplier) {
		T result;

		do {
			result =  getSupplierValueOrElseNull(supplier);
		} while(result == null);

		return result;
	}

	private <T> T getSupplierValueOrElseNull(Supplier<T> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			outputChannel.printLine(e.getMessage()+NEW_LINE);
			return null;
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
