package lotto.store;

import java.util.List;

import lotto.LottoNumbers;

public class Ticket {

	public Ticket(List<LottoNumbers> lottoList, int budget) {
		this.lottoList = lottoList;
		this.budget = budget;
	}

	private final List<LottoNumbers> lottoList;
	private final int budget;

	public int purchaseCount() {
		return lottoList.size();
	}

	public List<LottoNumbers> purchasedLotto() {
		return lottoList;
	}

}
