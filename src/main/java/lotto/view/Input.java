package lotto.view;

import lotto.utils.InputUtils;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private int money;
    private String inputLastLottoNumbers;

    public Input(Scanner scan) {
        scanner = scan;
    }

    public void moneyInput(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = scanner.nextInt();
        InputUtils.validMoneyGreaterZero(inputMoney);
        this.money = inputMoney;
    }

    public void inputLastWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.inputLastLottoNumbers = scanner.next();
    }

    public int getMoney(){
        return this.money;
    }

    public String getLastLottoNumber(){
        return this.inputLastLottoNumbers;
    }

}
