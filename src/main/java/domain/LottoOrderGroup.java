package domain;

import generate.LottoRandomNumber;

import java.util.ArrayList;
import java.util.List;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;

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
		LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();

		for (int i = 0; i < numberOfLotto; i++) {
			lottos.add(new Lotto(lottoRandomNumber.numbers(lottoRandomNumber.getRandomNumber(LOTTO_NUMBER_LENGTH))));
		}

		return lottos;
	}
}
