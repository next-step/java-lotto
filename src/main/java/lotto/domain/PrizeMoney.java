package lotto.domain;

public class PrizeMoney {

	public final long prizeMoney;

	public PrizeMoney(long prizeMoney) {
		if (prizeMoney < 0) {
			throw new IllegalArgumentException("당첨 금액은 음수일 수 없습니다.");
		}
		this.prizeMoney = prizeMoney;
	}

	public long getPrizeMoney() {
		return this.prizeMoney;
	}
}
