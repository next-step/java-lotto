package kht2199.lotto;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

import kht2199.lotto.exception.DomainException;
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

	private int assets;

	private final LottoList lottoList = new LottoList();

	private LottoResult lottoResult;

	private final LottoRule rule = new LottoRule();

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
		out.println("구입금액을 입력해 주세요.");
		assets = acceptAssets();
		int countsOfLotto = calculateLottoCount(assets, LOTTO_PRICE);
		purchase(countsOfLotto);
		output.printPurchased(lottoList);
		output.printLottoList(lottoList);
		lottoResult = input.lottoResult();
		lottoResult.updateLottoResult(lottoList);
		output.printResultStatistics(lottoResult);
	}

	/**
	 * 예산 조정.
	 * 테스트시 사용한다.
	 */
	protected void setAssets(int assets) {
		this.assets = assets;
	}

	/**
	 * 예산 조회.
	 * 테스트시 사용한다.
	 */
	protected int getAssets() {
		return assets;
	}

	protected LottoList getLottoList() {
		return lottoList;
	}

	/**
	 * 로또를 구매하고, 예산을 차감한다.
	 */
	protected void purchase(int countsOfLotto) throws LottoListNotEmptyException, AssetsNotEnoughException {
		if (this.lottoList.isNotEmpty()) {
			throw new LottoListNotEmptyException();
		}
		this.assets -= countsOfLotto * LOTTO_PRICE;
		if (assets < 0) {
			throw new AssetsNotEnoughException();
		}
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
