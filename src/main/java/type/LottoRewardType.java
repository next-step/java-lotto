package type;

import java.util.Arrays;

public enum LottoRewardType {
	NONE(0, 0),
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
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

	public static LottoRewardType of(final int collect, final boolean matchBonus) {
		return Arrays.stream(values())
					 .filter(value -> value.collect == collect)
					 .map(value -> mapToSecondWithMatchBonus(value, matchBonus))
					 .findFirst()
					 .orElse(NONE);
	}

	private static LottoRewardType mapToSecondWithMatchBonus(final LottoRewardType lottoRewardType, final boolean matchBonus) {
		if(lottoRewardType == SECOND && matchBonus == false){
			return THIRD;
		}
		return lottoRewardType;
	}

	public int reward() {
		return this.reward;
	}
	public String message() { return this.message; }
}
