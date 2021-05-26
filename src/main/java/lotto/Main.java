package lotto;

import java.util.Scanner;

import lotto.controller.LottoApp;
import lotto.view.LottoAppInput;
import lotto.view.LottoAppOutput;

public class Main {
	public static void main(String[] args) {
		LottoAppInput lottoAppInput = new LottoAppInput(new Scanner(System.in));
		LottoAppOutput lottoAppOutput = new LottoAppOutput(System.out);
		LottoApp lottoApp = new LottoApp(lottoAppOutput, lottoAppInput);
		lottoApp.run();
	}
}
