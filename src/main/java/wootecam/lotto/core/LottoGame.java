package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;

public class LottoGame {

	private final AutomaticLottoGenerator automaticLottoGenerator;

	public LottoGame(AutomaticLottoGenerator automaticLottoGenerator) {
		this.automaticLottoGenerator = automaticLottoGenerator;
	}

	public List<Lotto> getLottos(LottoCount lottoCount) {
		List<Lotto> lottos = new ArrayList<>(lottoCount.getCount());
		for (int i = 0; i < lottoCount.getCount(); i++) {
			lottos.add(this.automaticLottoGenerator.getNumbers());
		}
		return lottos;
	}
}
