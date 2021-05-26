package type;

import java.util.Arrays;

public enum LottoRewardType {
	NONE(0, 0),
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	;

	private final int collect;
	private final int reward;
	private final String message;

	LottoRewardType(final int collect, final int reward) {
		this(collect, reward, defaultMessage(collect, reward));
	}

	LottoRewardType(final int collect, final int reward, final String message) {
		this.collect = collect;
		this.reward = reward;
		this.message = message;
	}

	private static String defaultMessage(final int collect, final int reward) {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append(collect)
							.append("개 일치 (")
							.append(reward)
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
