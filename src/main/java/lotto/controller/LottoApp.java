package lotto.controller;

import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerator;
import lotto.model.LottoNumbersGroup;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.Rate;
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
		Money inputMoney = inputMoney();
		LottoNumbersGroup lottoNumbersGroup = inputLottoNumbersGroup((int) inputMoney.divided(Money.LOTTO_PRICE));
		LottoNumbers winningNumbers = inputWinningNumbers();
		printLottoResult(lottoNumbersGroup.match(winningNumbers), inputMoney);
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

	private void printLottoResult(LottoResult lottoResult, Money inputMoney) {
		Rate earningRate = lottoResult.calculateEarningRate(inputMoney);
		LottoResultDto resultDto = LottoResultDto.toDto(lottoResult, earningRate);
		lottoAppOutput.printLottoResult(resultDto);
	}
}
