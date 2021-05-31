package lotto.view;

import lotto.common.MessageCode;

import java.util.Scanner;

public class InputView {
    Scanner scan;
    private String inputLastWonLottoNumber;
    private String inputBonusNumber;
    private int inputAmount;

    public InputView() {
        scan = new Scanner(System.in);
    }

    public void inputMoneyForLotto() {
        System.out.println(MessageCode.INPUT_MONEY_FOR_LOTTO.message());
        inputAmount = scan.nextInt();
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void inputLastWonLottoNumbers() {
        System.out.println(MessageCode.INPUT_LAST_WON_LOTTO_NUMBERS.message());
        inputLastWonLottoNumber = scan.next();
    }

    public String getInputLastWonLottoNumbers() {
        return inputLastWonLottoNumber;
    }

    public String getInputBonusNumber() {
        return inputBonusNumber;
    }

    public void inputBonusLottoNumber() {
        System.out.println(MessageCode.INPUT_LAST_WON_BONUS_NUMBER.message());
        inputBonusNumber = scan.next();
    }
}
