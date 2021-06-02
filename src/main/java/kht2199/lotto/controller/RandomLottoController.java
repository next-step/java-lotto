package kht2199.lotto.controller;

import static kht2199.lotto.LottoGameState.*;

import kht2199.lotto.entity.Lotto;
import kht2199.lotto.entity.LottoAssets;
import kht2199.lotto.entity.LottoGame;
import kht2199.lotto.LottoGameState;
import kht2199.lotto.entity.LottoList;
import kht2199.lotto.entity.LottoNumber;
import kht2199.lotto.entity.LottoWinningResult;
import kht2199.lotto.exception.DomainException;
import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.input.InvalidInputException;
import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;
import kht2199.lotto.view.InputView;
import kht2199.lotto.view.ResultView;

/**
 * reusable, stateless instance.
 *
 * @author heetaek.kim
 */
public final class RandomLottoController {

	private final InputView input;

	private final ResultView output;

	private LottoGameState state;

	public RandomLottoController(InputView inputView, ResultView resultView) {
		this.input = inputView;
		this.output = resultView;
		this.state = INITIATING;
	}

	/**
	 * 예외 발생시 게임의 흐름을 제어한다.
	 */
	public void start(LottoGame game) {
		while (state != ENDED) {
			processAndUpdateState(game);
		}
	}

	public int acceptAssets() throws AssetsException, InvalidInputException {
		output.print("구입금액을 입력해 주세요.");
		return input.acceptAssets();
	}

	public int acceptLottoCountForManual() throws InvalidInputException {
		output.print("수동으로 구매할 로또 수를 입력해 주세요.");
		return input.acceptLottoCountForManual();
	}

	public LottoList acceptLotto(int count) {
		output.print("수동으로 구매할 번호를 입력해 주세요.");
		LottoList list = new LottoList();
		while (list.size() < count) {
			list.addLotto(acceptLottoIgnoreWhenExceptionOccur());
		}
		return list;
	}

	public Lotto acceptWinningNumbers() throws
			LottoNumberLengthException,
			InvalidInputException,
			LottoNumberRangeException {
		output.print("지난 주 당첨 번호를 입력해 주세요.");
		return input.acceptWinningNumbers();
	}

	public LottoNumber acceptBonusNumber() throws
			InvalidInputException,
			LottoNumberRangeException {
		output.print("보너스 볼을 입력해 주세요.");
		return input.acceptBonusNumber();
	}

	public void printLottoList(LottoList purchasedLottoList) {
		output.printLottoList(purchasedLottoList);
	}

	public void printException(DomainException e) {
		output.printException(e);
	}

	public void printResultStatistics(LottoGame game) {
		LottoWinningResult result = game.getWinningResult();
		LottoAssets assets = game.getAssets();
		output.printResultStatistics(result, assets);
	}

	private void processAndUpdateState(LottoGame game) {
		try {
			this.state = state.process(this, game);
		} catch (DomainException e) {
			printException(e);
		}
	}

	private Lotto acceptLottoIgnoreWhenExceptionOccur() {
		try {
			return input.acceptLotto();
		} catch (InvalidInputException | LottoNumberRangeException | LottoNumberLengthException e) {
			output.printException(e);
			return acceptLottoIgnoreWhenExceptionOccur();
		}
	}

}
