package lotto.view;

import lotto.common.LottoConstants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public int count(){

        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = inputMoney();

        while (!normal(inputMoney)) {
            System.out.println("금액을 천원 단위로 입력 하세요.");
            inputMoney = inputMoney();
        }

        return count(inputMoney);
    }

    public int inputMoney(){

        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("구매금액은 정수만 입력 가능합니다. 구매 금액을 다시 입력해 주세요.");
            return inputMoney();
        }
    }

    public String numbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public boolean normal(int money) {

        if (money <= LottoConstants.ZERO) {
            return false;
        }
        return money % LottoConstants.LOTTO_PRICE == LottoConstants.ZERO;
    }

    public int count(int buyMoney) {
        return buyMoney / LottoConstants.LOTTO_PRICE;
    }
}
