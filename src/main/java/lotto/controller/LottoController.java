package lotto.controller;

import lotto.model.Amount;
import lotto.view.InputView;

import java.util.Scanner;

public class LottoController {

    private Scanner scanner = new Scanner(System.in);

    private InputView inputView = new InputView();
    private Amount amount;

    public void run() {
        inputAmount();
    }

    private void inputAmount() {
        inputView.printAmountMessage();
        amount = new Amount(scanner.nextLine());
    }

}
