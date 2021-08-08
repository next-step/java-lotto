package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.AutoLottoNumbersGeneratorUtils;

public class Lottos {

	private static final int LOTTO_NUMBERS_LENGTH = 6;

	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos generateAutoLottos(int lottoSize) {
		List<Lotto> lottos = new ArrayList<Lotto>(lottoSize);

		for (int i = 0; i < lottoSize; i++) {
			lottos.add(new Lotto(AutoLottoNumbersGeneratorUtils.generateRandomNumbers(LOTTO_NUMBERS_LENGTH)));
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
