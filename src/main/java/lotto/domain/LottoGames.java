package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoGames {

	private final List<LottoGame> lottoGames;

	public LottoGames(List<LottoGame> lottoGames) {
		this.lottoGames = Collections.unmodifiableList(lottoGames);
	}

	public List<LottoGame> getLottoGames() {
		return lottoGames;
	}

	public ConfirmResults confirmPrize(GameWinningCondition lastWeekPrize) {
		return new ConfirmResults(lastWeekPrize.getPrizeResult(lottoGames));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoGames that = (LottoGames) o;
		return lottoGames.equals(that.lottoGames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoGames);
	}
}
