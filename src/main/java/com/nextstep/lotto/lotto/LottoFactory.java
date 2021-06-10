package com.nextstep.lotto.lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

	private static LottoNumberGenerator lottoNumberGenerator;

	public LottoFactory(RandomNumberGenerator lottoNumberGenerator) {
		this.lottoNumberGenerator = lottoNumberGenerator;
	}

	public static Lottos createLottos(int lottoCount) {
		return new Lottos(IntStream.range(0, lottoCount)
			.mapToObj(i -> lottoNumberGenerator.makeNumbers())
			.map(numbers -> new Lotto(numbers))
			.collect(Collectors.toList()));
	}
}
