package lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.factory.LottoFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoKiosk {

	public static final int LOTTO_PRICE = 1_000;

	public static Lottos issue(LottoPayAmounts lottoPayAmounts) {
		int countOfLotto = lottoPayAmounts.getCountOfLotto(LOTTO_PRICE);

		return Lottos.of(IntStream.range(0, countOfLotto)
								  .mapToObj(i -> LottoFactory.create())
								  .collect(Collectors.toList()));
	}
}
