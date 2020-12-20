package step2.domain;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoResults {

	private final Set<LottoResult> lottoResults;

	public LottoResults(final Lottos lottos) {
		this.lottoResults = new TreeSet<>();
		for (Lotto lotto : lottos.getLottos()) {
			addResult(LottoWin.of(lotto.getMatchCount()));
		}
	}

	private void addResult(final LottoWin lottoWin) {
		LottoResult lottoResult = new LottoResult(lottoWin);
		lottoResult.increase();

		if (!this.lottoResults.add(lottoResult)) {
			find(lottoResult).increase();
		}
	}

	private LottoResult find(final LottoResult lottoResult) {
		return this.lottoResults.stream()
			.filter(result -> result.equals(lottoResult))
			.findFirst()
			.orElseThrow(RuntimeException::new);
	}

	public Set<LottoResult> getLottoResults() {
		return lottoResults;
	}

	public Set<LottoResult> getWinLottoResults() {
		return this.lottoResults.stream()
			.filter(LottoResult::isWin)
			.collect(Collectors.toSet());
	}

	public boolean has(final LottoResult lottoResult) {
		return this.lottoResults.stream()
			.anyMatch(result -> result.equals(lottoResult));
	}
}
