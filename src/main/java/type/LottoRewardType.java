package type;

import java.util.Arrays;

public enum LottoRewardType {
	NONE(0, 0),
	PLACE_1TH(6, 2_000_000_000),
	PLACE_2TH(5, 1_500_000),
	PLACE_3TH(4, 50_000),
	PLACE_4TH(3, 5_000),
	;

	private final int collect;
	private final int reward;
	private final String message;

	LottoRewardType(final int collect, final int reward) {
		this.collect = collect;
		this.reward = reward;
		this.message = makeMessage();
	}

	private String makeMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append(this.collect)
							.append("개 일치 (")
							.append(this.reward)
							.append(")").toString();
	}

	public static LottoRewardType of(final int collect) {
		return Arrays.stream(values())
					 .filter(value -> value.collect == collect)
					 .findFirst()
					 .orElse(NONE);
	}

	public int reward() {
		return this.reward;
	}
	public String message() { return this.message; }
}
