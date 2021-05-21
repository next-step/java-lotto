package lotto.controller;

import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerator;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
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
		Money money = inputMoney();
		LottoTicket lottoTicket = inputLottoTicket(money.countOfLottoNumbers());
		LottoNumbers winningNumbers = inputWinningNumbers();
		printLottoResult(lottoTicket.match(winningNumbers), money);
	}

	private Money inputMoney() {
		lottoAppOutput.printMoneyInputView();
		return lottoAppInput.inputMoney();
	}

	private LottoTicket inputLottoTicket(int lottoNumbersCount) {
		lottoAppOutput.printBoughtLottoNumbersCountView(lottoNumbersCount);
		LottoTicket lottoTicket = new LottoTicket(lottoNumbersGenerator.generateRandomly(lottoNumbersCount));
		lottoAppOutput.printLottoTicket(lottoTicket);
		return lottoTicket;
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
