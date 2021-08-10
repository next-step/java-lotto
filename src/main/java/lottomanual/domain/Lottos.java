package lottomanual.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class Lottos {

	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos of(int money) {
		return IntStream.range(0, Money.of(money).getLottoCount())
				         .mapToObj(i -> Lotto.of(LottoNumberShuffle.generate()))
				         .collect(collectingAndThen(Collectors.toList(), Lottos::new));
	}

	public static Lottos of(String lottoNumber) {
		return new Lottos(Arrays.asList(Lotto.of(lottoNumber)));
	}

	public static Lottos of(String[] lottoNumbers) {
		return Arrays.stream(lottoNumbers)
		             .map(Lotto::of)
		             .collect(collectingAndThen(Collectors.toList(), Lottos::new));
	}

	public static Lottos of(int money, String[] lottoNumbers) {
		Money automaticAmount = Money.of(money)
		                             .excludeLottoCount(lottoNumbers.length);
		return of(lottoNumbers).buy(automaticAmount);
	}

	public Lottos buy(Money money) {
		int lottoCount = money.getLottoCount();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(Lotto.of(LottoNumberShuffle.generate()));
		}
		return new Lottos(lottos);
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> toList() {
		return Collections.unmodifiableList(lottos);
	}

}
