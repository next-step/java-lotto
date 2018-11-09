package lotto.dto;

import lotto.domain.ManualPickInfo;
import lotto.domain.Money;

public class PurchaseInfo {

	private Money money;
	private ManualPickInfo manualPickInfo;

	public PurchaseInfo(Money money, ManualPickInfo manualPickInfo) {
		this.money = money;
		this.manualPickInfo = manualPickInfo;
	}

	public Money getMoney() {
		return money;
	}

	public ManualPickInfo getManualPickInfo() {
		return manualPickInfo;
	}
}
