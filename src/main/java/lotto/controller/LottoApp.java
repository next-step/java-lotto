package lotto.controller;

import java.util.List;

import lotto.model.Count;
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
	private final LottoNumbersGenerateStrategy randomStrategy;
	private final LottoNumbersGenerateStrategy supplierStrategy;

	public LottoApp(LottoAppOutput lottoAppOutput, LottoAppInput lottoAppInput,
		LottoNumbersGenerateStrategy randomStrategy, LottoNumbersGenerateStrategy supplierStrategy) {
		this.lottoAppOutput = lottoAppOutput;
		this.lottoAppInput = lottoAppInput;
		this.randomStrategy = randomStrategy;
		this.supplierStrategy = supplierStrategy;
	}

	public void run() {
		Money money = inputMoney();
		Count manualCount = inputManualBuyCount();
		Count totalCount = money.countLotto();
		Count autoCount = totalCount.minus(manualCount);
		LottoTicket lottoTicket = inputLottoTicket(manualCount, autoCount);
		printLottoTicket(lottoTicket, manualCount, autoCount);
		WinningNumbers winningNumbers = inputWinningNumbers();
		printLottoResult(lottoTicket.match(winningNumbers), money);
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return Money.ofWons(lottoAppInput.inputNumber());
	}

	private LottoTicket inputLottoTicket(Count manualCount, Count autoCount) {
		List<LottoNumbers> manuals = inputManualNumbers(manualCount);
		List<LottoNumbers> autos = randomStrategy.generate(autoCount);
		return LottoTicket.of(manuals, autos);
	}

	private Count inputManualBuyCount() {
		lottoAppOutput.printManualCountInputView();
		return Count.of(lottoAppInput.inputNumber());
	}

	private List<LottoNumbers> inputManualNumbers(Count count) {
		lottoAppOutput.printManualLottoNumbersInputView();
		return supplierStrategy.generate(count);
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

	private void printLottoTicket(LottoTicket lottoTicket, Count manualCount, Count autoCount) {
		lottoAppOutput.printLottoTicket(lottoTicket, manualCount.getCount(), autoCount.getCount());
	}

	private void printLottoResult(LottoResult lottoResult, Money inputMoney) {
		Rate earningRate = lottoResult.calculateEarningRate(inputMoney);
		LottoResultDto resultDto = LottoResultDto.toDto(lottoResult, earningRate);
		lottoAppOutput.printLottoResult(resultDto);
	}
}
