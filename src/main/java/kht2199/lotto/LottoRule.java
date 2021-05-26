package kht2199.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.assets.AssetsNegativeException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;

/**
 *
 * @author heetaek.kim
 */
public final class LottoRule {

	private final Map<Integer, Integer> prizeMap;

	public LottoRule() {
		Map<Integer, Integer> prizeMap = new HashMap<>();
		prizeMap.put(3, 5000);
		prizeMap.put(4, 50000);
		prizeMap.put(5, 1500000);
		prizeMap.put(6, 2000000000);
		this.prizeMap = Collections.unmodifiableMap(prizeMap);
	}

	public void validateAssets(int assets) throws AssetsException {
		if (assets < 0) {
			throw new AssetsNegativeException();
		}
		if (assets < 1000) {
			throw new AssetsNotEnoughException();
		}
	}

	public int prize(int matched) {
		Integer prize = prizeMap.get(matched);
		return prize == null ? 0 : prize;
	}
}
