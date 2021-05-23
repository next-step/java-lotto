package automaticLotto;

import java.util.HashMap;
import java.util.Map;

public class WinnerStatics {
	private static final int WINNER_MINIMUM_CONDITION = 3;
	private static final int WINNER_MAXIMUM_CONDITION = 6;
	private static final int NOTHING = 0;

	private final Map<Integer, Integer> winnerCountByMatchedNumber;

	public WinnerStatics() {
		winnerCountByMatchedNumber = new HashMap<>();

		for (int i = WINNER_MINIMUM_CONDITION; i <= WINNER_MAXIMUM_CONDITION; i++) {
			winnerCountByMatchedNumber.put(i, NOTHING);
		}
	}

	public void addMatchedNumberCount(int matchedNumber) {
		int count;

		if (hasNumber(matchedNumber)) {
			count = winnerCountByMatchedNumber.get(matchedNumber);
			winnerCountByMatchedNumber.replace(matchedNumber, ++count);
		}
	}

	private boolean hasNumber(int matchedNumber) {
		return winnerCountByMatchedNumber.containsKey(matchedNumber);
	}

	public int presentCount(int matchedNumber) {
		if (!hasNumber(matchedNumber)) {
			return NOTHING;
		}

		return this.winnerCountByMatchedNumber.get(matchedNumber);
	}
}
