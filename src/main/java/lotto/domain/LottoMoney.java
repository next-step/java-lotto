package lotto.domain;

import lotto.exception.InsufficientMoneyException;

import java.util.Objects;

public class LottoMoney {

	private static final int PRICE_PER_LOTTO_TICKET = 1000;

	private final int amount;

	public LottoMoney(int amount) {
		validateMoneyAmount(amount);
		this.amount = amount;
	}

	public int availableLottoTicketsCount() {
		return amount / PRICE_PER_LOTTO_TICKET;
	}

	public double earningsRate(int totalPrizeMoney) {
		return (double) totalPrizeMoney / amount;
	}

	private void validateMoneyAmount(int amount) {
		if (isInsufficientForBuyingLottoTicket(amount)) {
			throw new InsufficientMoneyException(amount);
		}
	}

	private boolean isInsufficientForBuyingLottoTicket(int amount) {
		return amount < PRICE_PER_LOTTO_TICKET;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoMoney lottoMoney = (LottoMoney)o;
		return amount == lottoMoney.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
