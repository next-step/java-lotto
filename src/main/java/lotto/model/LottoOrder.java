package lotto.model;

import java.util.List;

/**
 * 로또 구입에 필요한 정보를 관리하는 개체
 * 수동번호, 주문 가능 금액 초과등을 판단
 */
public class LottoOrder {

	private static final int PRICE_OF_TICKET = 1000;

	private final int balance;

	private final List<LottoNumberSet> manualOrders;

	/**
	 * 주문서 생성
	 * @param investment 투자금(구입금액)
	 * @param manualOrders 수동구매 번호
	 */
	public LottoOrder(int investment, List<LottoNumberSet> manualOrders) {
		this.balance = investment - manualOrders.size() * PRICE_OF_TICKET;
		if(balance < 0){
			throw new IllegalArgumentException();
		}

		this.manualOrders = manualOrders;
	}

	public List<LottoNumberSet> getManualOrders() {
		return manualOrders;
	}

	public int getBalance() {
		return this.balance;
	}
}
