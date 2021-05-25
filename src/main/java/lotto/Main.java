package lotto;

import java.util.Scanner;

import lotto.controller.LottoApp;
import lotto.model.LottoNumbersGenerateStrategy;
import lotto.model.RandomGenerateStrategy;
import lotto.model.NumbersInputStrategy;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;

public class Main {
	public static void main(String[] args) {
		LottoAppInput lottoAppInput = new LottoAppInput(new Scanner(System.in));
		LottoAppOutput lottoAppOutput = new LottoAppOutput(System.out);
		LottoNumbersGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
		LottoNumbersGenerateStrategy numbersInputStrategy = new NumbersInputStrategy(lottoAppInput::inputNumbers);
		LottoApp lottoApp = new LottoApp(lottoAppOutput, lottoAppInput, randomGenerateStrategy, numbersInputStrategy);
		lottoApp.run();
	}
}
