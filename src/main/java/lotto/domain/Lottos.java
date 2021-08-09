package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.AutoLottoNumbersGeneratorUtils;

public class Lottos {

	private final List<Lotto> lottos;

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

	public RevenueRecord toRevenueRecord() {
		return new RevenueRecord(lottos);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
