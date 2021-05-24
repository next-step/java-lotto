package automaticLotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
	private static final int WINNER_MINIMUM_CONDITION = 3;
	private static final int WINNER_MAXIMUM_CONDITION = 6;
	private static final int NOTHING = 0;
	private static final int MAXIMUM_LOTTOS_SIZE = 100;

	private final List<Lotto> lottos;
	private Map<Integer, Integer> winnerCountByMatchedNumber;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
		validateLottosSize();
	}

	private void validateLottosSize() {
		if (lottos.size() > MAXIMUM_LOTTOS_SIZE) {
			throw new RuntimeException("the size of lottos can not exceed 100");
		}
	}

	public int size() {
		return this.lottos.size();
	}

	public WinnerTable announce(Lotto winnerLotto) {
		winnerCountByMatchedNumber = new HashMap<>();
		initiateWinnerCountByMatchedNumber();

		for (Lotto lotto : lottos) {
			addMatchedNumberCount(lotto.match(winnerLotto));
		}

		return new WinnerTable(winnerCountByMatchedNumber);
	}

	private void addMatchedNumberCount(int matchedNumber) {
		int count;

		if (hasNumber(matchedNumber)) {
			count = winnerCountByMatchedNumber.get(matchedNumber);
			winnerCountByMatchedNumber.replace(matchedNumber, ++count);
		}
	}

	private boolean hasNumber(int matchedNumber) {
		return winnerCountByMatchedNumber.containsKey(matchedNumber);
	}

	private void initiateWinnerCountByMatchedNumber() {
		for (int i = WINNER_MINIMUM_CONDITION; i <= WINNER_MAXIMUM_CONDITION; i++) {
			winnerCountByMatchedNumber.put(i, NOTHING);
		}
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}
}
