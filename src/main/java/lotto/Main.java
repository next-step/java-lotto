package lotto;

import java.util.Random;
import java.util.Scanner;

import lotto.controller.LottoApp;
import lotto.model.LottoNumbersGenerator;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;

public class Main {
	public static void main(String[] args) {
		LottoAppInput lottoAppInput = new LottoAppInput(new Scanner(System.in));
		LottoAppOutput lottoAppOutput = new LottoAppOutput(System.out);
		LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(new Random());
		LottoApp lottoApp = new LottoApp(lottoAppOutput, lottoAppInput, lottoNumbersGenerator);
		lottoApp.run();
	}
}
