package lotto.controller;

import java.util.List;
import java.util.function.Supplier;

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
		Money money = requireValidInput(this::inputMoney);
		Count totalCount = money.countLotto();
		Count manualCount = requireValidInput(() -> inputManualBuyCount(totalCount));
		Count autoCount = totalCount.minus(manualCount);
		LottoTicket lottoTicket = requireValidInput(() -> inputLottoTicket(manualCount, autoCount));
		printLottoTicket(lottoTicket, manualCount, autoCount);
		WinningNumbers winningNumbers = requireValidInput(this::inputWinningNumbers);
		printLottoResult(lottoTicket.match(winningNumbers), money);
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return Money.ofWons(lottoAppInput.inputNumber());
	}

	private LottoTicket inputLottoTicket(Count manualCount, Count autoCount) {
		List<LottoNumbers> manuals = inputManualNumbers(manualCount);
		List<LottoNumbers> autos = randomGenerateStrategy.generate(autoCount);
		return LottoTicket.of(manuals, autos);
	}

	private Count inputManualBuyCount(Count maxCount) {
		lottoAppOutput.printManualCountInputView();
		Count manualCount = Count.of(lottoAppInput.inputNumber());
		if (manualCount.greaterThan(maxCount)) {
			throw new IllegalArgumentException("최대 " + maxCount.getCount() + " 개 구입 가능");
		}
		return manualCount;
	}

	private List<LottoNumbers> inputManualNumbers(Count count) {
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

	private void printLottoTicket(LottoTicket lottoTicket, Count manualCount, Count autoCount) {
		lottoAppOutput.printLottoTicket(lottoTicket, manualCount.getCount(), autoCount.getCount());
	}

	private void printLottoResult(LottoResult lottoResult, Money inputMoney) {
		Rate earningRate = lottoResult.calculateEarningRate(inputMoney);
		LottoResultDto resultDto = LottoResultDto.toDto(lottoResult, earningRate);
		lottoAppOutput.printLottoResult(resultDto);
	}

	private <T> T requireValidInput(Supplier<T> supplier) {
		T inputResult = null;
		while (inputResult == null) {
			inputResult = input(supplier);
		}
		return inputResult;
	}

	private <T> T input(Supplier<T> input) {
		T result = null;
		try {
			result = input.get();
		} catch (IllegalArgumentException e) {
			lottoAppOutput.printMessage(e.getMessage());
		}
		return result;
	}
}
