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
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < lottoCount.getCount(); i++) {
			Lotto lotto = this.automaticLottoGenerator.getNumbers();
			lottos.add(lotto);
		}
		return lottos;
	}
}
