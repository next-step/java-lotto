package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoLotteriesFactory {
	public static LottoLotteries createAutoLottoLotteries(int count, LottoNumberGenerator lottoNumberGenerator) {
		return new LottoLotteries(createLottoLotteries(count, lottoNumberGenerator));
	}

	private static List<LottoLottery> createLottoLotteries(int count, LottoNumberGenerator lottoNumberGenerator) {
		return IntStream.range(0, count)
			.mapToObj(value -> new LottoLottery(lottoNumberGenerator.generate()))
			.collect(Collectors.toList());
	}
}
