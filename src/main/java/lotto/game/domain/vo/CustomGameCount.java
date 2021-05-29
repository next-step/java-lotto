package lotto.game.domain.vo;

import lotto.game.exception.IllegalCustomGameCountException;
import lotto.io.domain.vo.InputText;

public class CustomGameCount {
	public static final int EFFECTIVE_MIN_COUNT = 0;

	private final int count;

	private CustomGameCount(int number) {
		this.count = number;
	}

	public int count() {
		return this.count;
	}

	public static void validateGenerate(InputText inputText, Money money) {
		InputText.validateNumberFormatInputText(inputText);
		validateEffectiveCount(inputText.parseInt(), money.countOfGames());
	}

	private static void validateEffectiveCount(int number, int countOfGames) {
		if (!isEffectiveNumber(number, countOfGames)) {
			throw new IllegalCustomGameCountException("수동으로 구매할 로또 수는 " + EFFECTIVE_MIN_COUNT
				+ "이상이고, 구매가능한 개수(" + countOfGames + ") 이하의 자연수만 가능합니다. 입력된 값 : " + number);
		}
	}

	private static boolean isEffectiveNumber(int number, int countOfGames) {
		return EFFECTIVE_MIN_COUNT <= number && number <= countOfGames;
	}

	public static CustomGameCount generate(InputText inputText, Money money) {
		validateGenerate(inputText, money);
		return new CustomGameCount(inputText.parseInt());
	}
}
