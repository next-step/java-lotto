package lottoautomatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

	private static final int AMOUNT_UNIT = 1000;
	private final List<Lotto> lottoList = new ArrayList<>();

	public void buy(int amount, LottoNumberGenerator generator) {
		int lottoCount = amount / AMOUNT_UNIT;
		for (int i = 0; i < lottoCount; i++) {
			addLotto(generator);
		}
	}

	private void addLotto(LottoNumberGenerator generator) {
		Lotto lotto = new Lotto();
		lotto.generateNumbers(generator);
		lottoList.add(lotto);
	}

	public int size() {
		return lottoList.size();
	}

	public Map<Integer, Integer> match(List<Integer> winningNumbers) {
		Map<Integer, Integer> matchingResult = new HashMap<>();
		matchingResult.put(3, 0);
		matchingResult.put(4, 0);
		matchingResult.put(5, 0);
		matchingResult.put(6, 0);

		putIntoResult(winningNumbers, matchingResult);

		return matchingResult;
	}

	private void putIntoResult(List<Integer> winningNumbers, Map<Integer, Integer> matchingResult) {
		for (Lotto lotto : lottoList) {
			int matchingKey = lotto.matchingCount(winningNumbers);
			matchingResult.put(matchingKey, getMatchingCount(matchingResult, matchingKey));
		}
	}

	private int getMatchingCount(Map<Integer, Integer> resultMap, int match) {
		return resultMap.containsKey(match) ? resultMap.get(match) + 1 : 1;
	}

}
