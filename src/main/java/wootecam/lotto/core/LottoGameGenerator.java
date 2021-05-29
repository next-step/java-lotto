package wootecam.lotto.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import wootecam.lotto.model.BonusNumber;
import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoNumber;
import wootecam.lotto.model.WinningLotto;

public class LottoGameGenerator {

	public List<Lotto> getLottos(LottoGenerator lottoGenerator, int count) {
		return IntStream.range(0, count)
			.mapToObj(i -> lottoGenerator.getLotto())
			.collect(Collectors.toList());
	}

	public WinningLotto getWinningLotto(String winningLottoInput, String BonusNumberInput) {
		Lotto lotto = new Lotto(winningLottoInput);
		BonusNumber bonusNumber = new BonusNumber(LottoNumber.of(BonusNumberInput), lotto);

		return new WinningLotto(lotto, bonusNumber);
	}
}
