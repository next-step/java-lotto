package lotto.controller;

import java.util.List;

import lotto.model.LottoNumbers;
import lotto.model.LottoNumbersGenerator;
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
		List<LottoNumbers> lottoNumbers = buyLotto();
		System.out.println(lottoNumbers);
	}

	private List<LottoNumbers> buyLotto() {
		lottoAppOutput.printMoneyInputView();
		Money money = lottoAppInput.inputMoney();
		int lottoCount = money.calculateLottoCount();
		return lottoNumbersGenerator.generateRandomly(lottoCount);
	}
}
