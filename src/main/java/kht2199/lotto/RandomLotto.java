package kht2199.lotto;

import java.util.ArrayList;
import java.util.List;

import kht2199.lotto.data.Lotto;
import kht2199.lotto.data.LottoList;
import kht2199.lotto.exception.LottoListEmptyException;
import kht2199.lotto.exception.LottoListNotEmptyException;
import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.assets.AssetsNegativeException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;
import kht2199.lotto.view.InputView;
import kht2199.lotto.view.ResultView;

/**
 *
 * @author heetaek.kim
 */
public class RandomLotto {

	private static final int LOTTO_PRICE = 1000;

	private final InputView input;

	private final ResultView output;

	private final LottoGenerator generator = new LottoGenerator();

	private LottoList lottoList;

	private LottoWinningResult winningResult;

	/**
	 * 현재 예산.
	 */
	private int assets;

	private int assetsUsed;

	public RandomLotto(InputView inputView, ResultView resultView) {
		this.input = inputView;
		this.output = resultView;
	}

	/**
	 *
	 * @throws LottoListNotEmptyException 초기화 문제.
	 * @throws AssetsNotEnoughException 예산 부족.
	 */
	public void start() throws LottoListNotEmptyException, AssetsNotEnoughException, LottoListEmptyException {
		initForRestart();
		output.printInsertAssets();
		assets = acceptAssets();
		int countsOfLotto = calculateLottoCount(assets, LOTTO_PRICE);
		lottoList = purchase(countsOfLotto);
		// prints
		output.printPurchased(lottoList);
		output.printLottoList(lottoList);
		output.printAskWinningNumbers();
		// 로또 당첨번호.
		winningResult = new LottoWinningResult();
		input.acceptWinningNumbers(winningResult);
		// 로또 보너스번호.
		output.printAskBonusNumber();
		input.acceptBonusNumber(winningResult);
		// 결과 생성.
		winningResult.updateLottoWinningNumbers(lottoList);
		// 통계
		output.printResultStatistics(winningResult, assetsUsed);
	}

	/**
	 * 예산 조정.
	 * 테스트시 사용한다.
	 */
	protected void setAssets(int assets) {
		this.assets = assets;
	}

	/**
	 * 로또를 구매하고, 예산을 차감한다.
	 */
	protected LottoList purchase(int countsOfLotto) throws AssetsNotEnoughException, LottoListEmptyException {
		// validation.
		if (countsOfLotto <= 0) {
			throw new LottoListEmptyException();
		}
		if (this.assets < countsOfLotto * LOTTO_PRICE) {
			throw new AssetsNotEnoughException();
		}
		this.assetsUsed = countsOfLotto * LOTTO_PRICE;
		this.assets -= assetsUsed;
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < countsOfLotto; i++) {
			lottos.add(generator.random());
		}
		return new LottoList(lottos);
	}

	/**
	 * @return 구매가능한 로또 갯수를 반환한다,
	 */
	protected int calculateLottoCount(int assets, int lottoPrice) {
		return Math.floorDiv(assets, lottoPrice);
	}

	protected void validateAssets(int assets) throws AssetsException {
		if (assets < 0) {
			throw new AssetsNegativeException();
		}
		if (assets < 1000) {
			throw new AssetsNotEnoughException();
		}
	}

	/**
	 * 입력에 대한 예외처리를 위임하지 않고, 직접처리하기 위해.
	 *
	 * @return 예산금액.
	 */
	private int acceptAssets() {
		try {
			int assetsInput = input.assets();
			validateAssets(assetsInput);
			return assetsInput;
		} catch (AssetsException e) {
			output.handleException(e);
			return acceptAssets();
		}
	}

	private void initForRestart() {
		this.lottoList = null;
		this.winningResult = null;
		this.assets = 0;
		this.assetsUsed = 0;
	}

}
