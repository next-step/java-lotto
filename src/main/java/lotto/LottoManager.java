package lotto;

import exception.LottoException;
import ui.InputView;
import ui.ResultView;
import utils.*;

import java.math.BigDecimal;
import java.util.function.Predicate;

import static type.LottoExceptionType.SYSTEM_ERROR;

public final class LottoManager {
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	private final LottoGenerator lottoGenerator;

	public LottoManager() {
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(),
											DrawNumber.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
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
		for (int i = 0; i < lottoCount.userCount(); ++i) {
			LottoNumbers lottoNumbers = makeLottoNumbers(InputView.inputUserLottoNumber());
			this.lottoGenerator.add(lottoNumbers);
		}
	}

	private void createAutoLotto(final LottoCount lottoCount) {
		this.lottoGenerator.autoGenerate(lottoCount);
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
		return makeLottoNumbers(inputText);
	}

	private LottoNumbers makeLottoNumbers(final String text) {
		SeparatedText separatedText = SeparatedText.findSeparator(text);
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		return new LottoNumbers(NumberUtils.parseInts(texts, lottoNumberCondition()));
	}

	private Predicate<Integer> lottoNumberCondition() {
		return num -> {
			if (num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER) {
				return false;
			}
			return true;
		};
	}
}
