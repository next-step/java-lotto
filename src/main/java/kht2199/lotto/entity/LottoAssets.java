package kht2199.lotto.entity;

import kht2199.lotto.exception.assets.AssetsNotEnoughException;

public final class LottoAssets {

	/** 잔여 자산. */
	private int assets;

	/** 사용된 자산. */
	private int assetsUsed;

	public LottoAssets(int assets) {
		this.assets = assets;
	}

	public int getAssets() {
		return assets;
	}

	public int getAssetsUsed() {
		return assetsUsed;
	}

	void useMoney(int amount) throws AssetsNotEnoughException {
		if (assets < amount) {
			throw new AssetsNotEnoughException();
		}
		assetsUsed += amount;
		assets -= assetsUsed;
	}

	void updateAsset(int assets) {
		this.assets = assets;
	}

}
