package lotto.controller;

import java.util.List;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.RandomGenerateStrategy;
import lotto.model.Rate;
import lotto.model.SupplierGenerateStrategy;
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
		Money money = inputMoney();
		LottoTicket lottoTicket = inputLottoTicket(money);
		WinningNumbers winningNumbers = inputWinningNumbers();
		printLottoResult(lottoTicket.match(winningNumbers), money);
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return Money.ofWons(lottoAppInput.inputNumber());
	}

	private LottoTicket inputLottoTicket(Money money) {
		List<LottoNumbers> manuals = inputManualNumbers();
		int manualCount = manuals.size();
		int autoCount = money.countOfLottoNumbers() - manualCount;
		List<LottoNumbers> autos = generateAutoNumbers(autoCount);
		return LottoTicket.of(manuals, autos);
	}

	private List<LottoNumbers> inputManualNumbers() {
		lottoAppOutput.printManualCountInputView();
		int manualCount = lottoAppInput.inputNumber();
		lottoAppOutput.printManualLottoNumbersInputView();
		SupplierGenerateStrategy supplierGenerateStrategy = new SupplierGenerateStrategy(lottoAppInput::inputNumbers);
		return supplierGenerateStrategy.generate(manualCount);
	}

	private List<LottoNumbers> generateAutoNumbers(int autoCount) {
		RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
		return randomGenerateStrategy.generate(autoCount);
	}

	private WinningNumbers inputWinningNumbers() {
		return WinningNumbers.of(inputLottoNumbers(), inputBonusNumber());
	}

	private LottoNumbers inputLottoNumbers() {
		lottoAppOutput.printWinningNumbersInputView();
		return new LottoNumbers(lottoAppInput.inputNumbers());
	}

	private LottoNumber inputBonusNumber() {
		lottoAppOutput.printBonusNumberInputView();
		return LottoNumber.of(lottoAppInput.inputNumber());
	}

	private void printLottoResult(LottoResult lottoResult, Money inputMoney) {
		Rate earningRate = lottoResult.calculateEarningRate(inputMoney);
		LottoResultDto resultDto = LottoResultDto.toDto(lottoResult, earningRate);
		lottoAppOutput.printLottoResult(resultDto);
	}
}
