package lotto.game.domain.vo;

import lotto.game.exception.IllegalMoneyAmountException;
import lotto.io.domain.vo.InputText;

public class Money {
	public static final int EFFECTIVE_MIN_AMOUNT = 0;
	public static final int GAME_FEE = 1000;

	private final int amount;

	private Money(InputText inputText) {
		this.amount = parse(inputText);
	}

	public static void validateGenerate(InputText text) {
		validateNumberFormat(text);
		validateEffectiveAmount(text);
	}

	private static void validateNumberFormat(InputText text) {
		try {
			parse(text);
		} catch (NumberFormatException e) {
			throw new IllegalMoneyAmountException("Integer 값으로 parsing할 수 없습니다. 입력된 값 : " + text.value());
		}
	}

	private static void validateEffectiveAmount(InputText text) {
		int amount = parse(text);
		if (!isEffectiveAmount(amount)) {
			throw new IllegalMoneyAmountException("구입금액은 "
				+ EFFECTIVE_MIN_AMOUNT + "이상 자연수만 가능합니다. "
				+ "입력된 값 : " + amount);
		}
	}

	private static int parse(InputText text) {
		return Integer.parseInt(text.value());
	}

	private static boolean isEffectiveAmount(int amount) {
		return EFFECTIVE_MIN_AMOUNT <= amount;
	}

	public static Money generate(InputText inputText) {
		validateGenerate(inputText);
		return new Money(inputText);
	}

	public int countOfGames() {
		return this.amount / GAME_FEE;
	}

	public int amount() {
		return this.amount;
	}
}
