package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoResult {

	FAIL(0),
	WIN_5TH(5_000, "3개 일치"),
	WIN_4TH(50_000, "4개 일치"),
	WIN_3RD(1_500_000, "5개 일치"),
	WIN_2ND(30_000_000, "5개 일치, 보너스 볼 일치"),
	WIN_1ST(2_000_000_000, "6개 일치");

	private static Map<Integer, LottoResult> resultMap;

	static {
		resultMap = new HashMap<>();
		resultMap.put(0, FAIL);
		resultMap.put(1, FAIL);
		resultMap.put(2, FAIL);
		resultMap.put(3, WIN_5TH);
		resultMap.put(4, WIN_4TH);
		resultMap.put(5, WIN_3RD);
		resultMap.put(6, WIN_1ST);
	}

	private final int reward;

	private final String condition;

	LottoResult(int reward, String condition) {
		this.reward = reward;
		this.condition = condition;
	}

	LottoResult(int reward) {
		this(reward, null);
	}

	public int getReward() {
		return reward;
	}

	public String getCondition() {
		return condition;
	}

	public static LottoResult valueOfMatchedCount(int size) {
		return resultMap.get(size);
	}

	public static List<LottoResult> winResults(){
		return Arrays.asList(WIN_5TH, WIN_4TH, WIN_3RD, WIN_2ND, WIN_1ST);
	}
}
