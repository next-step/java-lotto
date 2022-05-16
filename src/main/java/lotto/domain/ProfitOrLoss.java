package lotto.domain;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ProfitOrLoss {
	PROFIT("이익", n -> n.moreThen(1D)),
	LOSS("손해", n -> n.lessThen(1D)),
	NOTHING("본전", n -> true),
	;

	private final String title;
	private final Predicate<Roi> condition;

	ProfitOrLoss(String title, Predicate<Roi> condition) {
		this.title = title;
		this.condition = condition;
	}

	public static ProfitOrLoss findByYield(Roi roi) {
		return Stream.of(ProfitOrLoss.values())
			.filter(value -> value.condition.test(roi))
			.findFirst()
			.orElse(NOTHING);
	}

	public String title() {
		return title;
	}
}
