package lotto;

import java.util.List;
import java.util.Set;

public class LottoIssueRequest {

	private int paidMoney;
	private List<Set<Integer>> manualNumbers;

	public LottoIssueRequest(int paidMoney, List<Set<Integer>> manualNumbers) {
		this.paidMoney = paidMoney;
		this.manualNumbers = manualNumbers;
		validate();
	}

	public int getPaidMoney() {
		return paidMoney;
	}

	public List<Set<Integer>> getManualNumbers() {
		return manualNumbers;
	}

	public int getAutoQuantity() {
		return paidMoney / Lotto.PRICE - manualNumbers.size();
	}

	private void validate() {
		validatePaidMoney();
		validateManualNumbers();
	}

	private void validatePaidMoney() {
		if (paidMoney % Lotto.PRICE != 0) {
			throw new IllegalArgumentException("거슬러주지 않아도 되는 정확한 금액이어야 합니다.");
		}
	}

	private void validateManualNumbers() {
		if (manualNumbers.size() > paidMoney / Lotto.PRICE) {
			throw new IllegalArgumentException("금액으로 구매 가능한만큼의 수동 번호를 선택해야 합니다.");
		}
	}
}
