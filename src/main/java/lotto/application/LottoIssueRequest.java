package lotto.application;

import lotto.domain.LottoMoney;

import java.util.List;
import java.util.Set;

public class LottoIssueRequest {

	private LottoMoney paidMoney;
	private List<Set<Integer>> manualNumbers;

	public LottoIssueRequest(LottoMoney paidMoney, List<Set<Integer>> manualNumbers) {
		this.paidMoney = paidMoney;
		this.manualNumbers = manualNumbers;
	}

	public List<Set<Integer>> getManualNumbers() {
		return manualNumbers;
	}

	public int getAutoQuantity() {
		return paidMoney.computePurchasableLottoQuantity(manualNumbers.size());
	}
}
