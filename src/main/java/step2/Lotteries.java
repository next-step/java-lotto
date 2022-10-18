package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotteries {

	private List<Lotto> lotteries;

	public Lotteries(List<Lotto> lotteries) {
		this.lotteries = lotteries;
	}

	public static Lotteries of(int totalTicket,LottoFactory lottoFactory) {

		List<Lotto> lotteries = new ArrayList<>();

		for (int i = 0; i < totalTicket; i++) {
			lotteries.add(new Lotto(lottoFactory));
		}

		return new Lotteries(lotteries);
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
		return Objects.equals(lotteries, lotteries.lotteries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotteries);
	}

}