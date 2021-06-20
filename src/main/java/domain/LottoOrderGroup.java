package domain;

import generate.DefaultLottoRandomNumberGenerator;
import generate.LottoRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoOrderGroup {
	private final List<Lotto> lottos;
	private final LottoRandomNumberGenerator lottoGenerator = new DefaultLottoRandomNumberGenerator();

	public LottoOrderGroup(Integer numberOfLotto) {
		this.lottos = generateLottos(numberOfLotto);
	}

	public void addHandLottos(List<Lotto> handLottos) {
		lottos.addAll(handLottos);
	}

	public List<Lotto> lottos() {
		return lottos;
	}

	public List<Lotto> generateLottos(Integer numberOfLotto) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < numberOfLotto; i++) {
			lottos.add(new Lotto(lottoGenerator));
		}

		return lottos;
	}
}
