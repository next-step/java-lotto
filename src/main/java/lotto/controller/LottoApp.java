package lotto.controller;

import java.util.List;

import lotto.model.LottoCount;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerateStrategy;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.Rate;
import lotto.model.WinningNumbers;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;
import lotto.view.dro.LottoResultDto;

public class LottoApp {
	private final LottoAppOutput lottoAppOutput;
	private final LottoAppInput lottoAppInput;
	private final LottoNumbersGenerateStrategy randomGenerateStrategy;
	private final LottoNumbersGenerateStrategy numbersInputStrategy;

	public LottoApp(LottoAppOutput lottoAppOutput, LottoAppInput lottoAppInput,
		LottoNumbersGenerateStrategy randomGenerateStrategy, LottoNumbersGenerateStrategy numbersInputStrategy) {
		this.lottoAppOutput = lottoAppOutput;
		this.lottoAppInput = lottoAppInput;
		this.randomGenerateStrategy = randomGenerateStrategy;
		this.numbersInputStrategy = numbersInputStrategy;
	}

	public void run() {
		Money money = lottoAppInput.requireValidInput(this::inputMoney, lottoAppOutput::printMessage);
		int manualCount = inputManualCount();
		LottoCount lottoCount = LottoCount.of(money, manualCount);
		LottoTicket lottoTicket = lottoAppInput.requireValidInput(() -> inputLottoTicket(lottoCount),
			lottoAppOutput::printMessage);
		printLottoTicket(lottoTicket, lottoCount);
		WinningNumbers winningNumbers = lottoAppInput.requireValidInput(this::inputWinningNumbers,
			lottoAppOutput::printMessage);
		printLottoResult(lottoTicket.match(winningNumbers), money);
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return Money.ofWons(lottoAppInput.inputNumber());
	}

	private LottoTicket inputLottoTicket(LottoCount lottoCount) {
		List<LottoNumbers> manuals = inputManualNumbers(lottoCount.getManualCount());
		List<LottoNumbers> autos = randomGenerateStrategy.generate(lottoCount.getAutoCount());
		return LottoTicket.of(manuals, autos);
	}

	private int inputManualCount() {
		lottoAppOutput.printManualCountInputView();
		return lottoAppInput.inputNumber();
	}

	private List<LottoNumbers> inputManualNumbers(int count) {
		lottoAppOutput.printManualLottoNumbersInputView();
		return numbersInputStrategy.generate(count);
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
