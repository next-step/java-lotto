package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.AutoLottoNumbersGeneratorUtils;

public class Lottos {

	private final List<Lotto> lottos;

	private Lottos() {
		this.lottos = new ArrayList<>();
	}

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos generateAutoLottos(int lottoSize) {
		List<Lotto> lottos = new ArrayList<Lotto>(lottoSize);

		for (int i = 0; i < lottoSize; i++) {
			lottos.add(Lotto.of(AutoLottoNumbersGeneratorUtils.generateRandomNumbers()));
		}

		return new Lottos(lottos);
	}

	public static Lottos generateLottos() {
		return new Lottos();
	}

	public RevenueRecord toRevenueRecord() {
		return new RevenueRecord(lottos);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public void addManualLotto(Lotto lotto) {
		lottos.add(lotto);
	}

	public void addAutoLotto() {
		lottos.add(Lotto.of(AutoLottoNumbersGeneratorUtils.generateRandomNumbers()));
	}
}
