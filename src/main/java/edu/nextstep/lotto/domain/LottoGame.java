package edu.nextstep.lotto.domain;

import java.util.List;

import edu.nextstep.lotto.domain.sub.LottoGameResult;
import edu.nextstep.lotto.domain.sub.Lottos;
import edu.nextstep.lotto.domain.sub.WinningLotto;

public class LottoGame {
	private final Lottos soldLottos;
	private final WinningLotto winningLotto;
	private final LottoGameResult lottoGameResult;

	public LottoGame(List<List<Integer>> soldLottos, List<Integer> firstRankLotto, int bonusNumber) {
		this.soldLottos = new Lottos(soldLottos);
		this.winningLotto = new WinningLotto(firstRankLotto, bonusNumber);
		this.lottoGameResult = new LottoGameResult(this.soldLottos, this.winningLotto);
	}

	public LottoGameResult getResult() {
		return lottoGameResult;
	}

}