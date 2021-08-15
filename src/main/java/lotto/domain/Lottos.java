package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.exception.OutOfLottoCountException;
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
		validate();

		lottos.add(lotto);
	}

	public Lotto addAutoLotto() {
		validate();

		Lotto lotto = Lotto.of(AutoLottoNumbersGeneratorUtils.generateRandomNumbers());

		lottos.add(lotto);

		return lotto;
	}

	private void validate() {
		if (lottos.size() >= lottoCount.getLottoCount()) {
			throw new OutOfLottoCountException("로또는 최대 " + lottoCount.getLottoCount() + "장 구매 가능합니다.");
		}
	}
}
