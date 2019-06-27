package lotto;

import java.util.HashMap;
import java.util.Map;

public enum LottoResult {

	WIN_1ST,
	WIN_2ND,
	WIN_3RD,
	WIN_4TH,
	FAIL;

	private static Map<Integer, LottoResult> resultMap;

	static {
		resultMap = new HashMap<>();
		resultMap.put(0, FAIL);
		resultMap.put(3, WIN_4TH);
		resultMap.put(4, WIN_3RD);
		resultMap.put(5, WIN_2ND);
		resultMap.put(6, WIN_1ST);
	}


	public static LottoResult valueOfMatchedCount(int size) {
		return resultMap.get(size);
	}
}
