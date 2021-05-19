package lotto.controller;

import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerator;
import lotto.model.LottoNumbersGroup;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;
import lotto.view.dro.LottoResultDto;

public class LottoApp {
	private final LottoAppOutput lottoAppOutput;
	private final LottoAppInput lottoAppInput;
	private final LottoNumbersGenerator lottoNumbersGenerator;

	public LottoApp(LottoAppOutput lottoAppOutput, LottoAppInput lottoAppInput,
		LottoNumbersGenerator lottoNumbersGenerator) {
		this.lottoAppOutput = lottoAppOutput;
		this.lottoAppInput = lottoAppInput;
		this.lottoNumbersGenerator = lottoNumbersGenerator;
	}

	public void run() {
		Money money = inputMoney();
		LottoNumbersGroup lottoNumbersGroup = inputLottoNumbersGroup(money.calculateLottoCount());
		LottoNumbers winningNumbers = inputWinningNumbers();
		printLottoResult(lottoNumbersGroup.match(winningNumbers));
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return lottoAppInput.inputMoney();
	}

	private LottoNumbersGroup inputLottoNumbersGroup(int lottoCount) {
		lottoAppOutput.printBoughtLottoCountView(lottoCount);
		LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(lottoNumbersGenerator.generateRandomly(lottoCount));
		lottoAppOutput.printLottoNumbersGroup(lottoNumbersGroup);
		return lottoNumbersGroup;
	}

	private LottoNumbers inputWinningNumbers() {
		lottoAppOutput.printWinningNumbersInputView();
		return new LottoNumbers(lottoAppInput.inputWinningNumbers());
	}

	private void printLottoResult(LottoResult lottoResult) {
		LottoResultDto resultDto = LottoResultDto.from(lottoResult);
		lottoAppOutput.printLottoResult(resultDto);
	}
}
