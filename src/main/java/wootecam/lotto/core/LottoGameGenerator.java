package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.List;

import wootecam.lotto.model.BonusNumber;
import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoNumber;
import wootecam.lotto.model.WinningLotto;

public class LottoGameGenerator {

	private final AutomaticLottoGenerator automaticLottoGenerator;

	private final ManualLottoGenerator manualLottoGenerator;

	public LottoGameGenerator(AutomaticLottoGenerator automaticLottoGenerator,
		ManualLottoGenerator manualLottoGenerator) {
		this.automaticLottoGenerator = automaticLottoGenerator;
		this.manualLottoGenerator = manualLottoGenerator;
	}

	public List<Lotto> getLottos(LottoCount lottoCount) {
		List<Lotto> lottos = new ArrayList<>();

		lottoCount.manualForeach(() -> {
			Lotto lotto = this.manualLottoGenerator.getLotto();
			lottos.add(lotto);
		});

		lottoCount.automaticForeach(() -> {
			Lotto lotto = this.automaticLottoGenerator.getLotto();
			lottos.add(lotto);
		});

		return lottos;
	}

	public WinningLotto getWinningLotto(String winningLottoInput, String BonusNumberInput) {
		Lotto lotto = new Lotto(winningLottoInput);
		BonusNumber bonusNumber = new BonusNumber(LottoNumber.of(BonusNumberInput), lotto);

		return new WinningLotto(lotto, bonusNumber);
	}
}
