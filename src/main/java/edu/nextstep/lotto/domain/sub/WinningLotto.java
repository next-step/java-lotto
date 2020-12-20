package edu.nextstep.lotto.domain.sub;

import java.util.List;

public class WinningLotto {
	private final Lotto firstRankLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(List<Integer> firstRankLotto, int bonusNumber) {
		if (firstRankLotto.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함되지 않는 번호로 지정해야 합니다.");
		}
		this.firstRankLotto = new Lotto(firstRankLotto);
		this.bonusNumber = new LottoNumber(bonusNumber);
	}

	public Lotto getFirstRankLotto() {
		return firstRankLotto;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
