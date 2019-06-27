package lotto;

import java.util.HashMap;
import java.util.Map;

public enum LottoResult {

	WIN_1ST(2000000000, "6개 일치"),
	WIN_2ND(1500000, "5개 일치"),
	WIN_3RD(50000, "4개 일치"),
	WIN_4TH(5000, "3개 일치"),
	FAIL(0);

	private static Map<Integer, LottoResult> resultMap;

	static {
		resultMap = new HashMap<>();
		resultMap.put(0, FAIL);
		resultMap.put(1, FAIL);
		resultMap.put(2, FAIL);
		resultMap.put(3, WIN_4TH);
		resultMap.put(4, WIN_3RD);
		resultMap.put(5, WIN_2ND);
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

	public static LottoResult valueOfMatchedCount(int size) {
		return resultMap.get(size);
	}

}
