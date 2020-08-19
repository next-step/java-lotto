package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.configuration.LottoConfig.LOTTO_MAX_NUM;
import static step2.configuration.LottoConfig.LOTTO_MIN_NUM;

public class LottoGameFactory {

	private static final List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
																		.mapToObj(LottoNumber::new)
																		.collect(Collectors.toList());

	private LottoGameFactory() {}

	public static LottoGame getNewLottoGame() {
		Collections.shuffle(lottoNumberPool);
		return new LottoGame(lottoNumberPool);
	}
}
