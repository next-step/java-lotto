package ui;

public enum LottoReward {
	MATCH_3(5000),
	MATCH_4(50000),
	MATCH_5(1500000),
	MATCH_6(2000000000);

	private Integer money;

	LottoReward (Integer money) {
		this.money = money;
	}

	public Integer getMoney () {
		return money;
	}
}
