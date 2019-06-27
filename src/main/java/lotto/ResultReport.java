package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResultReport {

	Map<LottoResult, Integer> resultStats;

	public ResultReport(){
		resultStats = new HashMap<>();
	}

	public int countOfResult(LottoResult result) {
		return Optional.ofNullable(resultStats.get(result)).orElse(0);
	}

	public int increment(LottoResult result) {
		int count = countOfResult(result);
		resultStats.put(result, ++count);

		return count;
	}
}
