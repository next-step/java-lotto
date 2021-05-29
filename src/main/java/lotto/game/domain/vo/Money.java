package lotto.game.domain.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import lotto.game.domain.code.PrizeCode;
import lotto.game.exception.IllegalMoneyException;
import lotto.io.domain.vo.InputText;

public class Money {
	public static final int EFFECTIVE_MIN_AMOUNT = 0;
	public static final int GAME_FEE = 1000;
	private static final int INITIALIZE_VALUE_ZERO = 0;
	private static final int TWO_OF_DECIMAL_PLACES = 2;
	private static final String PATTERN_TWO_OF_DECIMAL_PLACES = "#.##";

	private final int amount;

	private Money(InputText inputText) {
		this.amount = inputText.parseInt();
	}

	public static Money generate(InputText inputText) {
		validateGenerate(inputText);
		return new Money(inputText);
	}

	public static void validateGenerate(InputText text) {
		InputText.validateNumberFormatInputText(text);
		validateEffectiveAmount(text.parseInt());
	}

	private static void validateEffectiveAmount(int number) {
		if (!isEffectiveAmount(number)) {
			throw new IllegalMoneyException("구입금액은 "
				+ EFFECTIVE_MIN_AMOUNT + "이상 자연수만 가능합니다. "
				+ "입력된 값 : " + number);
		}
	}

	private static boolean isEffectiveAmount(int amount) {
		return EFFECTIVE_MIN_AMOUNT <= amount;
	}

	private static void validateNotNull(Object object) {
		if (Objects.isNull(object)) {
			throw new IllegalMoneyException("Money는 null일 수 없습니다.");
		}
	}

	private static void validateGameFee(int amount) {
		if (amount < Money.GAME_FEE) {
			throw new IllegalMoneyException("1개 이상의 게임을 구매할 수 있는 " + Money.GAME_FEE + "원 이상의 금액이 필요합니다.");
		}
	}

	public static void validateMoneyForGame(Money money) {
		validateNotNull(money);
		validateEffectiveAmount(money.amount);
		validateGameFee(money.amount);
	}

	public int countOfGames() {
		return this.amount / GAME_FEE;
	}

	public int amount() {
		return this.amount;
	}

	public static String calculateEarningRate(Map<PrizeCode, Integer> winningStatistics, int gameCounts) {
		BigDecimal numerator = calculateNumeratorOfEarningRate(winningStatistics);
		BigDecimal denominator = BigDecimal.valueOf((long) gameCounts * Money.GAME_FEE);
		double earningRate = numerator
			.divide(denominator, TWO_OF_DECIMAL_PLACES, RoundingMode.FLOOR).doubleValue();
		DecimalFormat decimalFormat = new DecimalFormat(PATTERN_TWO_OF_DECIMAL_PLACES);
		return decimalFormat.format(earningRate);
	}

	private static BigDecimal calculateNumeratorOfEarningRate(Map<PrizeCode, Integer> winningStatistics) {
		return Arrays.stream(PrizeCode.values())
			.map(prizeCode -> {
				int countOfPrize = winningStatistics.get(prizeCode);
				int winningAmount = prizeCode.winningAmount();
				return BigDecimal.valueOf(countOfPrize).multiply(BigDecimal.valueOf(winningAmount));
			})
			.reduce(BigDecimal.valueOf(INITIALIZE_VALUE_ZERO), BigDecimal::add);
	}
}
