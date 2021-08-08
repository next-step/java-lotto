package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Records;
import lotto.view.ResultView;

public class LottoController {

	private final int money;
	private final LottoCount lottoCount;
	private Lottos lottos;
	private Lotto winLotto;

	public LottoController(int money) {
		this.money = money;
		this.lottoCount = new LottoCount(this.money);
	}

	public void buyLotto() {
		ResultView.outputLottoCount(lottoCount.getLottoCount());
		this.lottos = Lottos.generateAutoLottos(lottoCount.getLottoCount());

		lottos.getLottos()
			.forEach(ResultView::outputLottoNumbers);
	}

	public void winLotto(String winLottoNumbers) {
		String[] stringLottoNumbers = winLottoNumbers.split(",");

		List<Integer> lottoNumbers = Arrays.stream(stringLottoNumbers)
			.map(String::trim)
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());

		this.winLotto = new Lotto(lottoNumbers);
	}

	public Records getRecords() {
		return lottos.toRevenueRecord().aggregate(winLotto);
	}

	public int getMoney() {
		return money;
	}
}
