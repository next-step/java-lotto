package step2.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResults {

	private final Map<LottoWin, Integer> lottoResults;

	public LottoResults(final Lottos lottos, final LottoNumbers winLottoNumbers, final LottoNumber bonusNumber) {
		validateBonusNumberDuplication(winLottoNumbers, bonusNumber);
		this.lottoResults = new LinkedHashMap<>();
		addResult(lottos, winLottoNumbers, bonusNumber);
	}

	private void validateBonusNumberDuplication(final LottoNumbers winLottoNumbers, final LottoNumber bonusNumber) {
		if (winLottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 볼 숫자는 당첨 번호 숫자와 중복되어선 안됩니다.");
		}
	}

	private void addResult(final Lottos lottos, final LottoNumbers winLottoNumbers, final LottoNumber bonusNumber) {
		for (Lotto lotto : lottos.getLottos()) {
			LottoWin lottoWin = LottoWin.of(lotto.getMatchCount(winLottoNumbers),
				lotto.matchesBonusNumber(bonusNumber));
			this.lottoResults.merge(lottoWin, 1, (k, v) -> v + 1);
		}
	}

	public Map<LottoWin, Integer> getLottoResults() {
		return Collections.unmodifiableMap(lottoResults);
	}

	public long getWinPrice() {
		return this.lottoResults.entrySet().stream()
			.filter(lottoWinIntegerEntry -> lottoWinIntegerEntry.getKey().isWin())
			.mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
			.sum();
	}

	public Integer get(final LottoWin lottoWin) {
		return this.lottoResults.get(lottoWin);
	}
}
