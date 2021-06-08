package com.nextstep.lotto.lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

	private static RandomNumberGenerator randomNumberGenerator;

	public LottoFactory(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public static Lottos createLottos(int lottoCount) {
		return new Lottos(IntStream.range(0, lottoCount)
			.mapToObj(i -> randomNumberGenerator.makeRandomNumbers())
			.map(Lotto::new)
			.collect(Collectors.toList()));
	}
}
