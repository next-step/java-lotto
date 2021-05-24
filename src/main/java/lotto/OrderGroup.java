package lotto;

import generate.LottoRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class OrderGroup {
	private final List<Lotto> lottos;

	public OrderGroup (Integer numberOfLotto) {
		this.lottos = generateLotto(numberOfLotto);
	}

	public List<Lotto> lottos () {
		return lottos;
	}

	public List<Lotto> generateLotto(Integer numberOfLotto) {
		List<Lotto> lottos = new ArrayList<>();

		for (Integer i = 0; i < numberOfLotto; i++) {
			Integer[] lottoNumbers = LottoRandomNumber.numbers();

			lottos.add(new Lotto(lottoNumbers));
		}

		return lottos;
	}
}
