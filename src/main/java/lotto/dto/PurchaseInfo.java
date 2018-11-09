package lotto.dto;

import java.util.List;
import lotto.domain.Money;

public class PurchaseInfo {

	private Money money;
	private List<String> manualNumbers;

	public PurchaseInfo(Money money, List<String> manualNumbers) {
		this.money = money;
		this.manualNumbers = manualNumbers;
	}

	public Money getMoney() {
		return money;
	}

	public List<String> getManualNumbers() {
		return manualNumbers;
	}

	public int getQuickPickCount() {
		return money.getPickCount() - manualNumbers.size();
	}
}
