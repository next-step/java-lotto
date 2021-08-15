package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.AutoLottoNumbersGeneratorUtils;

public class Lottos {

	private final LottoCount lottoCount;
	private final List<Lotto> lottos;

	private Lottos(LottoCount lottoCount) {
		this.lottos = new ArrayList<>(lottoCount.getLottoCount());
		this.lottoCount = lottoCount;
	}

	public static Lottos generateLottos(LottoCount lottoCount) {
		return new Lottos(lottoCount);
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
