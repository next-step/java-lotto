package edu.nextstep.lotto.domain;

import java.util.List;

import edu.nextstep.lotto.domain.sub.Lotto;
import edu.nextstep.lotto.domain.sub.LottoGameResult;
import edu.nextstep.lotto.domain.sub.LottoNumber;
import edu.nextstep.lotto.domain.sub.Lottos;

public class LottoGame {
	private final Lottos soldLottos;
	private final Lotto winningLotto;
	private final LottoNumber bonusNumber;
	private final LottoGameResult lottoGameResult;

	private LottoGame(List<List<Integer>> soldLottos, List<Integer> winningLotto, int bonusNumber) {
		this.soldLottos = new Lottos(soldLottos);
		this.winningLotto = new Lotto(winningLotto);
		this.bonusNumber = new LottoNumber(bonusNumber);
		this.lottoGameResult = new LottoGameResult(this.soldLottos, this.winningLotto, this.bonusNumber);
	}

	public static LottoGame createOf(
		List<List<Integer>> soldLottos, List<Integer> winningLotto, int bonusNumber) {
		if (winningLotto.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함되지 않는 번호로 지정해야 합니다.");
		}
		return new LottoGame(soldLottos, winningLotto, bonusNumber);
	}

	public LottoGameResult getResult() {
		return lottoGameResult;
	}

}