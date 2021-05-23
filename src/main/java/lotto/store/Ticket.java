package lotto.store;

import java.util.List;

import lotto.LottoNumbers;

public class Ticket {

	public Ticket(List<LottoNumbers> lottoList) {
		this.lottoList = lottoList;
	}

	private final List<LottoNumbers> lottoList;

	public int purchaseCount() {
		return lottoList.size();
	}

}
