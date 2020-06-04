package lotto.application;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbers;

import java.util.List;

public class LottoIssueRequest {

	private LottoMoney paidMoney;
	private List<LottoNumbers> manualNumbersList;

	public LottoIssueRequest(LottoMoney paidMoney, List<LottoNumbers> manualNumbersList) {
		this.paidMoney = paidMoney;
		this.manualNumbersList = manualNumbersList;
	}

	public List<LottoNumbers> getManualNumbersList() {
		return manualNumbersList;
	}

	public int getAutoQuantity() {
		return paidMoney.computePurchasableLottoQuantity(manualNumbersList.size());
	}
}
