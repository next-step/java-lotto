package step2.constants;

import step2.LottoException;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum RateOfReturn {

	GAIN("이득임", rateOfReturn -> rateOfReturn > 1D),
	SAME("이득도 손해도 아님", rateOfReturn -> rateOfReturn == 1D),
	LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임", rateOfReturn -> rateOfReturn >= 0D && rateOfReturn < 1D);

	private final String message;

	private final Predicate<Double> getRateOfReturn;

	private static final Map<Predicate<Double>, RateOfReturn> valuesMap = Arrays.stream(RateOfReturn.values())
																			.collect(Collectors.toMap(rateOfReturn -> rateOfReturn.getRateOfReturn, Function.identity()));

	RateOfReturn(String message, Predicate<Double> getRateOfReturn) {
		this.message = message;
		this.getRateOfReturn = getRateOfReturn;
	}

	public static RateOfReturn of(double rateOfReturn) {
		return make(rateOfReturn)
					.orElseThrow(() -> new LottoException("손익 비율은 음수가 될 수 없습니다."));
	}

	private static Optional<RateOfReturn> make(double rateOfReturn) {

		return valuesMap.entrySet()
				.stream()
				.filter(entry -> entry.getKey().test(rateOfReturn))
				.map(entry -> entry.getValue())
				.findFirst();
	}

	public String getMessage() {
		return message;
	}
}
