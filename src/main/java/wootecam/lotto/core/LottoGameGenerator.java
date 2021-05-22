package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;

public class LottoGameGenerator {

	private final AutomaticLottoGenerator automaticLottoGenerator;

	public LottoGameGenerator(AutomaticLottoGenerator automaticLottoGenerator) {
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

	public Lotto getWinningLotto(String winningLottoInput) {
		List<Integer> winningLottoList = Arrays.stream(winningLottoInput.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return new Lotto(winningLottoList);
	}
}
