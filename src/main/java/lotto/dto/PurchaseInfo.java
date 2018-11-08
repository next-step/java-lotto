package lotto.dto;

public class PurchaseInfo {

	private int money;
	private int manualPickCount;

	public PurchaseInfo(int money, int manualPickCount) {
		this.money = money;
		this.manualPickCount = manualPickCount;
	}

	public int getMoney() {
		return money;
	}

	public int getManualPickCount() {
		return manualPickCount;
	}
}
