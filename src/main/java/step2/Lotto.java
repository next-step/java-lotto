package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

	private List<Integer> lottoSet;

	public Lotto(List<Integer> lottoSet) {
		this.lottoSet = lottoSet;
	}

	public static Lotto randomNumLotto() {

		List<Integer> totalLottoNum = new ArrayList<Integer>();
		List<Integer> lottoSet = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			totalLottoNum.add(i);
		}

		Collections.shuffle(totalLottoNum);

		for (int i = 0; i < 6; i++) {
			lottoSet.add(totalLottoNum.get(i));
		}

		Collections.sort(lottoSet);
		return new Lotto(lottoSet);

	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotto lotto = (Lotto) o;
		return Objects.equals(lottoSet, lotto.lottoSet);
	}

	public int hashCode() {
		return Objects.hash(lottoSet);
	}
}
