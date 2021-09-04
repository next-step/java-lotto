package domain;

public enum Rank {
	FIRST(6, 2000000000),
	SECOND(5,1500000),
	THIRD(4,50000),
	FOUR(3,5000),
	NO(0,0);

	private int matchNumber;
	private int amount;

	Rank(int matchNumber, int amount) {
		this.matchNumber = matchNumber;
		this.amount = amount;
	}

	public static Rank rank(int matchNumber) {
		Rank[] ranks = values();
		for(Rank rank : ranks) {
			if(match(rank, matchNumber)) {
				return rank;
			}
		}
		return NO;
	}

	public static boolean match(Rank rank, int matchNumber) {
		return rank.matchNumber == matchNumber;
	}

	public Integer getAmount() {
		return amount;
	}
}
