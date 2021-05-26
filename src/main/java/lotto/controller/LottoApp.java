package lotto.controller;

import static lotto.view.LottoAppInput.*;

import java.util.List;

import lotto.model.LottoCount;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerateStrategy;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.NumbersInputStrategy;
import lotto.model.RandomGenerateStrategy;
import lotto.model.Rate;
import lotto.model.WinningNumbers;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;
import lotto.view.dro.LottoResultDto;

public class LottoApp {
	private final LottoAppOutput lottoAppOutput;
	private final LottoAppInput lottoAppInput;

	public LottoApp(LottoAppOutput lottoAppOutput, LottoAppInput lottoAppInput) {
		this.lottoAppOutput = lottoAppOutput;
		this.lottoAppInput = lottoAppInput;
	}

	public void run() {
		Money money = requireValidInput(this::inputMoney, lottoAppOutput::printMessage);

		LottoCount lottoCount = requireValidInput(() -> inputLottoCount(money), lottoAppOutput::printMessage);

		LottoTicket lottoTicket = requireValidInput(() -> inputLottoTicket(lottoCount), lottoAppOutput::printMessage);
		printLottoTicket(lottoTicket, lottoCount);

		WinningNumbers winningNumbers = requireValidInput(this::inputWinningNumbers, lottoAppOutput::printMessage);
		printLottoResult(lottoTicket.match(winningNumbers), money);
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return Money.ofWons(lottoAppInput.inputNumber());
	}

	private LottoCount inputLottoCount(Money money) {
		int manualCount = inputManualCount();
		return LottoCount.of(money, manualCount);
	}

	private int inputManualCount() {
		lottoAppOutput.printManualCountInputView();
		return lottoAppInput.inputNumber();
	}

	private LottoTicket inputLottoTicket(LottoCount lottoCount) {
		List<List<Integer>> inputNumbers = inputManualNumbers(lottoCount.getManualCount());
		LottoNumbersGenerateStrategy numbersInputStrategy = new NumbersInputStrategy(inputNumbers);
		LottoNumbersGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy(lottoCount.getAutoCount());
		return LottoTicket.create(numbersInputStrategy, randomGenerateStrategy);
	}

	private List<List<Integer>> inputManualNumbers(int manualCount) {
		lottoAppOutput.printManualLottoNumbersInputView();
		return lottoAppInput.inputNumbers(manualCount);
	}

	private WinningNumbers inputWinningNumbers() {
		return WinningNumbers.of(inputLottoNumbers(), inputBonusNumber());
	}

	private LottoNumbers inputLottoNumbers() {
		lottoAppOutput.printWinningNumbersInputView();
		return LottoNumbers.of(lottoAppInput.inputNumbers());
	}

	private LottoNumber inputBonusNumber() {
		lottoAppOutput.printBonusNumberInputView();
		return LottoNumber.of(lottoAppInput.inputNumber());
	}

	private void printLottoTicket(LottoTicket lottoTicket, LottoCount lottoCount) {
		lottoAppOutput.printLottoTicket(lottoTicket, lottoCount.getManualCount(), lottoCount.getAutoCount());
	}

	private void printLottoResult(LottoResult lottoResult, Money inputMoney) {
		Rate earningRate = lottoResult.calculateEarningRate(inputMoney);
		LottoResultDto resultDto = LottoResultDto.toDto(lottoResult, earningRate);
		lottoAppOutput.printLottoResult(resultDto);
	}
}
