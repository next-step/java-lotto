package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.configuration.LottoConfig.LOTTO_MAX_NUM;
import static step3.configuration.LottoConfig.LOTTO_MIN_NUM;

public class LottoNumberFactory {

	private static final List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
																	.mapToObj(LottoNumber::new)
																	.collect(Collectors.toList());

	private LottoNumberFactory() {}

	public static List<LottoNumber> getLottoNumberPool() {
		return lottoNumberPool;
	}
}
