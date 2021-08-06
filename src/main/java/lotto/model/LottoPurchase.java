package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.service.GenerateLotto;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static List<Lotto> buyLottos(int lottoCount) {
		return IntStream.range(START_INCLUSIVE, lottoCount)
			.mapToObj(i -> new Lotto(GenerateLotto.generateLottoNumbers()))
			.collect(Collectors.toList());
	}

}
