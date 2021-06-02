package kht2199.lotto.entity;

import static kht2199.lotto.entity.LottoGameState.*;

import kht2199.lotto.LottoGenerator;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;

public class LottoGame {

	private static final int LOTTO_PRICE = 1000;

	private static final LottoGenerator generator = new LottoGenerator();

	private final LottoList purchasedList;

	private final LottoAssets assets;

	private LottoWinningResult winningResult;

	public LottoGame() {
		this.purchasedList = new LottoList();
		this.assets = new LottoAssets(0);
	}

	public void initAssets(int assets) {
		this.assets.updateAsset(assets);
	}

	public LottoWinningResult getWinningResult() {
		return winningResult;
	}

	public LottoAssets getAssets() {
		return assets;
	}

	public LottoList getPurchasedLottoList() {
		return purchasedList;
	}

	public void updateLottoWinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) throws
			LottoBonusNumberDuplicatedException {
		LottoWinningResult winningResult = new LottoWinningResult(winningNumbers, bonusNumber);
		winningResult.updateLottoWinningNumbers(purchasedList);
		this.winningResult = winningResult;
	}

	/**
	 * 로또를 랜덤으로 구매하고, 예산을 차감한다.
	 */
	public LottoList purchaseRandom(int countsOfLotto)
		throws AssetsNotEnoughException {
		if (countsOfLotto == 0) {
			return new LottoList();
		}
		LottoList list = generator.randoms(countsOfLotto);
		purchase(list);
		return list;
	}

	/**
	 * 로또를 구매하고, 예산을 차감한다.
	 */
	public void purchase(LottoList list)
			throws AssetsNotEnoughException {
		if (list.isEmpty()) {
			return;
		}
		assets.useMoney(list.size() * LOTTO_PRICE);
		purchasedList.addLottoNumbers(list);
	}

	public int calculatePurchasableLottoCount() {
		return Math.floorDiv(assets.getAssets(), LOTTO_PRICE);
	}

	public void validatePurchasable(int count) throws AssetsNotEnoughException {
		if (assets.getAssets() < count * LOTTO_PRICE) {
			throw new AssetsNotEnoughException();
		}
	}
}
