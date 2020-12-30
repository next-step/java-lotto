package lotto.domain.result;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.result.MatchResultPerLotto;
import lotto.model.LottoPrizePolicy;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchResultList {
	List<MatchResultPerLotto> matchResultPerLottos = new ArrayList<>();

	public LottoMatchResultList(List<MatchResultPerLotto> matchResultPerLottos) {
		this.matchResultPerLottos = matchResultPerLottos;
	}

	public LottoMatchResultList(Lotto lastWeekPrizeNumbers, LottoList purchasedLottos, LottoNumber bonusNumber) {
		this.matchResultPerLottos.addAll(this.compareLastWeekPrizeNumberWithPurchasedLottoNumber(lastWeekPrizeNumbers, purchasedLottos, bonusNumber));
	}

	public void add(MatchResultPerLotto matchResultPerLotto) {
		this.matchResultPerLottos.add(matchResultPerLotto);
	}

	public List<MatchResultPerLotto> getLottoMatchResults() {
		return matchResultPerLottos;
	}

	public List<MatchResultPerLotto> compareLastWeekPrizeNumberWithPurchasedLottoNumber(Lotto lastWeekPrizeNumbers, LottoList purchasedLottos, LottoNumber bonusNumber) {
		List<MatchResultPerLotto> lottoMatchResultLists = new ArrayList<>();
		for (Lotto lotto : purchasedLottos.getLottoList()) {
			HasBonusNumber isMatchBonus = LottoPrizePolicy.isMatchBonusNumber(lotto, bonusNumber);
			MatchCount matchCount = lastWeekPrizeNumbers.countMatchNumber(lotto);
			MatchResultPerLotto matchResultPerLotto = new MatchResultPerLotto(matchCount, isMatchBonus);
			lottoMatchResultLists.add(matchResultPerLotto);
		}
		return lottoMatchResultLists;
	}
}
