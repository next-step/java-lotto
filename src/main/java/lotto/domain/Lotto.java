package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private final List<Integer> lotto;

	public Lotto(List<Integer> lotto) {
		this.lotto = lotto;
	}

	public List<Integer> getLotto() {
		return lotto;
	}

	protected MatchResult match(WinLotto winLotto) {
		int count = (int)lotto.stream()
			.filter(winLotto.getWinLotto()::contains)
			.count();
		boolean matchBonus = false;
		if (count == 5 && lotto.contains(winLotto.getBonus())) {
			matchBonus = true;
		}
		return new MatchResult(count, matchBonus);
	}

	public LottoRank rankLotto(WinLotto winLotto) {
		MatchResult matchResult = match(winLotto);
		return LottoRank.valueOf(matchResult.getCount(), matchResult.isMatchBonus());
	}

	@Override
	public String toString() {
		return "["+lotto.stream().map(lotto -> Integer.toString(lotto)).collect(Collectors.joining(", "))+"]";
	}
}
