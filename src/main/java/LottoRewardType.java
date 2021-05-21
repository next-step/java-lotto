import java.util.Arrays;

public enum LottoRewardType {
	NONE(0, 0),
	PLACE_1TH(6, 2_000_000_000),
	PLACE_2TH(5, 1_500_000),
	PLACE_3TH(4, 50_000),
	PLACE_4TH(3, 5_000),
	;

	private int collect;
	private int reward;

	LottoRewardType(final int collect, final int reward){
		this.collect = collect;
		this.reward = reward;
	}

	public static LottoRewardType reward(final int collect){
		return Arrays.stream(values())
					 .filter(value -> value.collect == collect)
					 .findFirst()
					 .orElse(NONE);
	}
}
