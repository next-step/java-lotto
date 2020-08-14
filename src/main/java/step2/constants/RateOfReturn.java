package step2.constants;

import step2.LottoException;

import java.util.Optional;

public enum RateOfReturn {

	GAIN("이득임"),
	SAME("이득도 손해도 아님"),
	LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임");

	private final String message;

	RateOfReturn(String message) {
		this.message = message;
	}

	public static RateOfReturn of(double rateOfReturn) {
		return Optional.ofNullable(make(rateOfReturn))
						.orElseThrow(() -> new LottoException("손익 비율은 음수가 될 수 없습니다."));
	}

	private static RateOfReturn make(double rateOfReturn) {
		if(rateOfReturn >= 0D && rateOfReturn < 1D) {
			return LOSS;
		}
		if(rateOfReturn == 1D) {
			return SAME;
		}
		if(rateOfReturn > 1D) {
			return GAIN;
		}

		return null;
	}

	public String getMessage() {
		return message;
	}
}
