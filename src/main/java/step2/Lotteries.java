package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotteries {

	private List<Lotto> lottos;

	public Lotteries(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lotteries of(int round,LottoFactory lottoFactory) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < round; i++) {
			lottos.add(new Lotto(lottoFactory));
		}

		return new Lotteries(lottos);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotteries lotteries = (Lotteries) o;
		return Objects.equals(lottos, lotteries.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottos);
	}

}