package lotto.dto;

import java.util.List;
import lotto.domain.LottoMachine;

public class PurchaseInfo {

	private int money;
	private List<String> manualNumbers;

	public PurchaseInfo(int money, List<String> manualNumbers) {
		this.money = money;
		this.manualNumbers = manualNumbers;
	}

	public int getMoney() {
		return money;
	}

	public List<String> getManualNumbers() {
		return manualNumbers;
	}

	public int getQuickPickCount() {
		return getPickCount() - getManualPickCount();
	}

	private int getPickCount() {
		return money / LottoMachine.LOTTO_PRICE;
	}

	public int getManualPickCount() {
		return manualNumbers.size();
	}
}
