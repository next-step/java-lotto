package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private static final int LOTTO_SIZE = 6;

	private final List<LottoNumber> lotto;

	public Lotto(List<LottoNumber> lotto) {
		validateLotto(lotto);
		this.lotto = lotto;
	}

	public List<LottoNumber> getLotto() {
		return lotto;
	}

	private void validateLotto(List<LottoNumber> lotto) {
		if (lotto.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또는 6자리 숫자만 입력 가능합니다.");
		}
	}

	protected MatchResult match(WinLotto winLotto) {
		int count = (int)lotto.stream()
			.filter(l -> winLotto.getWinLotto().lotto.contains(l))
			.count();
		boolean matchBonus = lotto.contains(winLotto.getBonus());
		return new MatchResult(count, matchBonus);
	}

	public LottoRank rankLotto(WinLotto winLotto) {
		MatchResult matchResult = match(winLotto);
		return LottoRank.valueOf(matchResult.getCount(), matchResult.isMatchBonus());
	}

	@Override
	public String toString() {
		return "["+lotto.stream().map(lotto -> Integer.toString(lotto.getLottoNumber())).collect(Collectors.joining(", "))+"]";
	}
}
