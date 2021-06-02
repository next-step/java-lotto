package lotto.dto;

import lotto.Prize;

public class PrizeDto {
	private int count;
	private long amount;
	private int status;
	private boolean bonusMatch;

	public PrizeDto(Prize prize, int status) {
		this.count = prize.count();
		this.amount = prize.win().amount();
		this.status = status;
		this.bonusMatch = prize.equals(Prize.SECOND);
	}

	public int count() {
		return count;
	}

	public long amount() {
		return amount;
	}

	public int status() {
		return status;
	}

	public boolean isBonusMatch() {
		return bonusMatch;
	}
}
