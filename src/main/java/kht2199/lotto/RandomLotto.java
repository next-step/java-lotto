package kht2199.lotto;

import java.util.ArrayList;
import java.util.List;

import kht2199.lotto.exception.LottoListNotEmptyException;
import kht2199.lotto.exception.assets.AssetsException;
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

	private final LottoList lottoList = new LottoList();

	private final LottoRule rule = new LottoRule();

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
	public void start() throws LottoListNotEmptyException, AssetsNotEnoughException {
		output.printInsertAssets();
		assets = acceptAssets();
		int countsOfLotto = calculateLottoCount(assets, LOTTO_PRICE);
		purchase(countsOfLotto);
		// prints
		output.printPurchased(lottoList);
		output.printLottoList(lottoList);
		output.printMessageForWinningNumbers();
		//
		Lotto winningNumbers = input.acceptWinningNumbers();
		LottoWinningResult lottoWinningResult = new LottoWinningResult(winningNumbers);
		lottoWinningResult.updateLottoWinningNumbers(rule, lottoList);
		//
		output.printResultStatistics(rule, lottoWinningResult, assetsUsed);
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
	protected void purchase(int countsOfLotto) throws LottoListNotEmptyException, AssetsNotEnoughException {
		// validation.
		if (this.lottoList.isNotEmpty()) {
			throw new LottoListNotEmptyException();
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
		this.lottoList.setList(lottos);
	}

	/**
	 * @return 구매가능한 로또 갯수를 반환한다,
	 */
	protected int calculateLottoCount(int assets, int lottoPrice) {
		return Math.floorDiv(assets, lottoPrice);
	}

	/**
	 * 입력에 대한 예외처리를 위임하지 않고, 직접처리하기 위해.
	 *
	 * @return 예산금액.
	 */
	private int acceptAssets() {
		try {
			int assetsInput = input.assets();
			rule.validateAssets(assetsInput);
			return assetsInput;
		} catch (AssetsException e) {
			output.handleException(e);
			return acceptAssets();
		}
	}

}
