package lotto;

import exception.LottoException;
import ui.InputView;
import ui.ResultView;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import static type.LottoExceptionType.SYSTEM_ERROR;

public final class LottoManager {

	private final LottoGenerator lottoGenerator;

	public LottoManager() {
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory());
	}

	public void run() {
		try {
			startLotto();
		} catch(LottoException e) {
			ResultView.printExceptionMessage(e);
		} catch(Exception e) {
			ResultView.printExceptionMessage(LottoException.of(SYSTEM_ERROR));
		}
	}

	private void startLotto() {
		LottoMoney lottoMoney = new LottoMoney(InputView.inputPrice());
		buyLotto(lottoMoney);
		calculateResult(new WinningLottoNumbers(inputWinningNumber(), bonusLottoNumber()),
						lottoMoney);
	}

	private void buyLotto(final LottoMoney lottoMoney) {
		LottoCount lottoCount = new LottoCount(lottoMoney, InputView.inputUserLottoCount());
		createUserLotto(lottoCount);
		createAutoLotto(lottoCount);
		ResultView.printResultBuyLotto(lottoCount,
									   this.lottoGenerator.lottoNumbersFactory());
	}

	private void createUserLotto(final LottoCount lottoCount) {
		if(lottoCount.isEmptyUserCount()){
			return;
		}
		InputView.printUserLotto();
		List<String> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < lottoCount.userCount(); ++i) {
			lottoNumbers.add(InputView.inputUserLottoNumber());
		}
		this.lottoGenerator.generateManualLotto(lottoNumbers);
	}

	private void createAutoLotto(final LottoCount lottoCount) {
		this.lottoGenerator.generateAutoLotto(lottoCount);
	}

	private LottoNumber bonusLottoNumber() {
		return new LottoNumber(InputView.inputBonusNumber());
	}

	private void calculateResult(final WinningLottoNumbers winningLottoNumbers, final LottoMoney lottoMoney) {
		ResultView.printWinningLottoNumber();
		LottoResult lottoResult = this.lottoGenerator.summary(winningLottoNumbers);
		BigDecimal revenue = lottoResult.calculateRevenue(lottoMoney);
		ResultView.printCalculateRevenue(lottoResult, revenue);
	}

	private LottoNumbers inputWinningNumber() {
		String inputText = InputView.inputWinningNumber();
		return LottoGenerator.makeLottoNumbers(inputText);
	}

}
