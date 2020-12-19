package edu.nextstep.lotto.domain;

import java.util.List;

import edu.nextstep.lotto.domain.sub.Lotto;
import edu.nextstep.lotto.domain.sub.LottoGameResult;
import edu.nextstep.lotto.domain.sub.Lottos;

public class LottoGame {
	private final Lottos soldLottos;
	private final Lotto winningLotto;
	private final LottoGameResult lottoGameResult;

	public LottoGame(List<List<Integer>> soldLottos, List<Integer> winningLotto) {
		this.soldLottos = new Lottos(soldLottos);
		this.winningLotto = new Lotto(winningLotto);
		this.lottoGameResult = new LottoGameResult(this.soldLottos, this.winningLotto);
	}

	public LottoGameResult getResult() {
		return lottoGameResult;
	}

}