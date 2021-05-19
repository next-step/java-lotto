package lotto.controller;

import java.util.List;

import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerator;
import lotto.model.LottoNumbersGroup;
import lotto.model.Money;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;

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
		LottoNumbersGroup lottoNumbersGroup = buyLottoNumbersGroup();
		lottoAppOutput.printLottoNumbersGroup(lottoNumbersGroup);
		LottoNumbers winningNumbers = inputWinningNumbers();
	}

	private LottoNumbersGroup buyLottoNumbersGroup() {
		lottoAppOutput.printMoneyInputView();
		Money money = lottoAppInput.inputMoney();
		int lottoCount = money.calculateLottoCount();
		lottoAppOutput.printBoughtLottoCountView(lottoCount);
		return new LottoNumbersGroup(lottoNumbersGenerator.generateRandomly(lottoCount));
	}

	private LottoNumbers inputWinningNumbers() {
		lottoAppOutput.printWinningNumbersInputView();
		return new LottoNumbers(lottoAppInput.inputWinningNumbers());
	}
}
