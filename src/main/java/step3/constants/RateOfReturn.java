package step3.constants;

import step3.LottoException;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum RateOfReturn {

	GAIN("이득임", rateOfReturn -> rateOfReturn > 1D),
	SAME("이득도 손해도 아님", rateOfReturn -> rateOfReturn == 1D),
	LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임", rateOfReturn -> rateOfReturn >= 0D && rateOfReturn < 1D);

	private final String message;

	private final Predicate<Double> getRateOfReturn;

	RateOfReturn(String message, Predicate<Double> getRateOfReturn) {
		this.message = message;
		this.getRateOfReturn = getRateOfReturn;
	}

	public static RateOfReturn of(double rateOfReturn) {
		return Arrays.stream(RateOfReturn.values())
				.filter(value -> value.getRateOfReturn.test(rateOfReturn))
				.findFirst()
				.orElseThrow(() -> new LottoException("손익 비율은 음수가 될 수 없습니다."));
	}

	public String getMessage() {
		return message;
	}
}
