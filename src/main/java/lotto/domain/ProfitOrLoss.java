package lotto.domain;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ProfitOrLoss {
	PROFIT("이익", n -> n.moreThen(1D)),
	LOSS("손해", n -> n.lessThen(1D)),
	NOTHING("본전", n -> true),
	;

	private final String title;
	private final Predicate<Yield> condition;

	ProfitOrLoss(String title, Predicate<Yield> condition) {
		this.title = title;
		this.condition = condition;
	}

	public static ProfitOrLoss findByYield(Yield yield) {
		return Stream.of(ProfitOrLoss.values())
			.filter(value -> value.condition.test(yield))
			.findFirst()
			.orElse(NOTHING);
	}

	public String title() {
		return title;
	}
}
