package kht2199.lotto;

import static java.lang.System.*;

import kht2199.lotto.exception.assets.AssetsException;
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

	private int assets;

	private LottoList lottoList;

	private LottoResult lottoResult;

	private final LottoRule rule = new LottoRule();

	public RandomLotto(InputView inputView, ResultView resultView) {
		this.input = inputView;
		this.output = resultView;
	}

	public void start() {
		out.println("구입금액을 입력해 주세요.");
		assets = acceptAssets();
		int purchased = purchase(assets, LOTTO_PRICE);
		output.printPurchased(purchased);
		output.printLottoList(lottoList);
		lottoResult = input.lottoResult();
		lottoResult.updateLottoResult(lottoList);
		output.printResultStatistics(lottoResult);
	}

	/**
	 *
	 * @param assets 예산.
	 * @param lottoPrice 로또 개별 금액.
	 * @return 구매한 갯수.
	 */
	protected int purchase(int assets, int lottoPrice) {
		// TODO 로또 구매 후 정산
		return calculateLottoCount(assets, lottoPrice);
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
