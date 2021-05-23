package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoNumber;

public class LottoGameGenerator {

	private final AutomaticLottoGenerator automaticLottoGenerator;

	public LottoGameGenerator(AutomaticLottoGenerator automaticLottoGenerator) {
		this.automaticLottoGenerator = automaticLottoGenerator;
	}

	public List<Lotto> getLottos(LottoCount lottoCount) {
		List<Lotto> lottos = new ArrayList<>();

		lottoCount.foreach(() -> {
			Lotto lotto = this.automaticLottoGenerator.getLotto();
			lottos.add(lotto);
		});

		return lottos;
	}

	public Lotto getWinningLotto(String winningLottoInput) {
		List<LottoNumber> winningLottoList = Arrays.stream(winningLottoInput.split(","))
			.map(LottoNumber::new)
			.distinct()
			.collect(Collectors.toList());
		return new Lotto(winningLottoList);
	}
}
