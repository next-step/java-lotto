package lotto.store;

import java.util.List;

import lotto.LottoNumbers;

public class Ticket {

	public Ticket(List<LottoNumbers> lottoList, Budget budget) {
		this.lottoList = lottoList;
		this.budget = budget;
	}

	private final List<LottoNumbers> lottoList;
	private final Budget budget;

	public int purchaseCount() {
		return lottoList.size();
	}

	public List<LottoNumbers> purchasedLotto() {
		return lottoList;
	}

	public int budget() {
		return budget.get();
	}

	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();
		for (LottoNumbers lottoNumbers : lottoList) {
			message.append(lottoNumbers);
			message.append("\n");
		}
		return message.toString();
	}
}
