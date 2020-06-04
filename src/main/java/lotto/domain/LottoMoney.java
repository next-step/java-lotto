package lotto.domain;

public class LottoMoney {

	int money;

	private LottoMoney(int money) {
		this.money = money;
	}

	public static LottoMoney of(int money) {
		validate(money);
		return new LottoMoney(money);
	}

	private static void validate(int money) {
		if (money % Lotto.PRICE != 0) {
			throw new IllegalArgumentException("거슬러주지 않아도 되는 정확한 금액이어야 합니다.");
		}
	}

	public int computePurchasableLottoQuantity(int alreadyOccupiedLottoQuantity) {
		int purchasableLottoQuantityTotal = computePurchasableLottoQuantityTotal();

		if (purchasableLottoQuantityTotal < alreadyOccupiedLottoQuantity) {
			throw new IllegalArgumentException("금액으로 구매 불가능한 수량의 로또가 구매 예정되었습니다.");
		}

		return purchasableLottoQuantityTotal - alreadyOccupiedLottoQuantity;
	}

	private int computePurchasableLottoQuantityTotal() {
		return money / Lotto.PRICE;
	}
}
