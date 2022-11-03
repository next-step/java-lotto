package step3.model.amount;

import step3.exception.BadRequestException;
import step3.util.NumberUtil;

public class Amount {

	private static final int LOTTE_PRICE = 1000;		// 로또 가격

	private final int purchase;						// 구입금액
	private final int manualCount;					// 수동 로또 개수
	private final int automaticCount;				// 자동 로또 개수

	public Amount(int purchase, int manualCount) {
		checkPurchase(purchase);
		this.purchase = purchase;
		checkManualCount(manualCount);
		this.manualCount = manualCount;
		this.automaticCount = getLottoCount() - manualCount;
	}

	public int getLottoCount() {
		return purchase / LOTTE_PRICE;
	}

	public int getManualCount() {
		return this.manualCount;
	}

	public int getAutomaticCount() {
		return this.automaticCount;
	}

	public double getYield(double prize) {
		return Math.floor(prize / purchase * 100) / 100;
	}

	public void checkPurchase(int amount) {
		if (amount < LOTTE_PRICE){
			throw new BadRequestException("입력가능한 최소 구매 금액은 1000 입니다.");
		}
	}

	public void checkManualCount(int manualCount) {
		if (!NumberUtil.isInRange(manualCount, 0, getLottoCount())) {
			throw new BadRequestException("수동으로 구매가능한 개수가 아닙니다.");
		}
	}
}
