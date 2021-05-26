package kht2199.lotto;

import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.assets.AssetsNegativeException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;

/**
 *
 * @author heetaek.kim
 */
public final class LottoRule {

	public LottoRule() {}

	public void validateAssets(int assets) throws AssetsException {
		if (assets < 0) {
			throw new AssetsNegativeException();
		}
		if (assets < 1000) {
			throw new AssetsNotEnoughException();
		}
	}

	public int prize(int matched) {
		if (matched == 3) {
			return 5000;
		}
		if (matched == 4) {
			return 50000;
		}
		if (matched == 5) {
			return 1500000;
		}
		if (matched == 6) {
			return 2000000000;
		}
		return 0;
	}
}
