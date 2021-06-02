package domain;

import generate.LottoRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoOrderGroup {
	private final List<Lotto> lottos;

	public LottoOrderGroup (Integer numberOfLotto) {
		this.lottos = generateLotto(numberOfLotto);
	}

	public List<Lotto> lottos () {
		return lottos;
	}

	public List<Lotto> generateLotto (Integer numberOfLotto) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < numberOfLotto; i++) {
			lottos.add(new Lotto(LottoRandomNumber.numbers()));
		}

		return lottos;
	}
}
