package lotto.ui;

import java.util.Arrays;
import java.util.function.Predicate;

public enum GainLossDiscriminator {

	GAIN("이득임", rateOfReturn -> rateOfReturn > 1D),
	SAME("이득도 손해도 아님", rateOfReturn -> rateOfReturn == 1D),
	LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임", rateOfReturn -> rateOfReturn >= 0D && rateOfReturn < 1D);

	private static final String YIELD_SHOULD_NOT_NEGATIVE = "손익 비율은 음수가 될 수 없습니다.";

	private final String message;
	private final Predicate<Double> gainLossPredicate;

	GainLossDiscriminator(String message, Predicate<Double> gainLossPredicate) {
		this.message = message;
		this.gainLossPredicate = gainLossPredicate;
	}

	public static GainLossDiscriminator of(double yield) {
		return Arrays.stream(GainLossDiscriminator.values())
					.filter(value -> value.gainLossPredicate.test(yield))
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException(YIELD_SHOULD_NOT_NEGATIVE));
	}

	public String getMessage() {
		return message;
	}
}
