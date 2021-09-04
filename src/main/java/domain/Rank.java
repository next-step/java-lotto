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
		if(matchNumber == 6) {
			return FIRST;
		}
		if(matchNumber == 5) {
			return SECOND;
		}
		if(matchNumber == 4) {
			return THIRD;
		}
		if(matchNumber == 3) {
			return FOUR;
		}
		return NO;
	}
}
