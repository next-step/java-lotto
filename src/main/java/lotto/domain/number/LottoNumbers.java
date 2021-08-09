package lotto.domain.number;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumbers {

	private static LottoNumbers lottoNumbers;
	private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

	private LottoNumbers() {
		IntStream.range(1, 46)
			.boxed()
			.forEach(v -> {
				lottoNumberMap.put(v, new LottoNumber(v));
			});
	}

	public static LottoNumbers generate() {
		if (lottoNumbers == null) {
			return new LottoNumbers();
		}

		return lottoNumbers;
	}

	public LottoNumber valueOf(int lottoNumber) {
		return lottoNumberMap.get(lottoNumber);
	}
}
