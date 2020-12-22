package step2.domain;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoResults {

	private final Set<LottoResult> lottoResults;

	public LottoResults(final Lottos lottos, final LottoNumber bonusNumber) {
		this.lottoResults = new TreeSet<>();
		addResults();
		matchIncrease(lottos, bonusNumber);
	}

	private void addResults() {
		for (LottoWin lottoWin : LottoWin.values()) {
			this.lottoResults.add(new LottoResult(lottoWin));
		}
	}

	private void matchIncrease(final Lottos lottos, final LottoNumber bonusNumber) {
		for (Lotto lotto : lottos.getLottos()) {
			increase(lotto, bonusNumber);
		}
	}

	private void increase(final Lotto lotto, final LottoNumber bonusNumber) {
		for (LottoResult lottoResult : lottoResults) {
			lottoResult.increaseIfEqualsMatchCount(lotto.getMatchCount(), lotto.matchesBonusNumber(bonusNumber));
		}
	}

	public Set<LottoResult> getWinLottoResults() {
		return this.lottoResults.stream()
			.filter(LottoResult::isWin)
			.collect(Collectors.toCollection(TreeSet::new));
	}

	public boolean has(final LottoResult lottoResult) {
		return this.lottoResults.stream()
			.anyMatch(result -> result.equals(lottoResult));
	}

	public long getWinPrice() {
		return getWinLottoResults().stream()
			.mapToInt(LottoResult::getWinPrice)
			.sum();
	}
}
