package lotto.domain;

public class WinningMoney {

	private final long winningMoney;

	public WinningMoney(long winningMoney) {
		if (winningMoney < 0) {
			throw new IllegalArgumentException("당첨 금액은 음수일 수 없습니다.");
		}
		this.winningMoney = winningMoney;
	}

	public long getWinningMoney() {
		return this.winningMoney;
	}

	@Override
	public String toString() {
		return String.valueOf(this.winningMoney);
	}
}
