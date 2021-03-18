package lotto.view;

import lotto.common.LottoConstants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public int money(){
        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = inputMoney();

        while (!normal(inputMoney)) {
            System.out.println("금액을 천원 단위로 입력 하세요.");
            inputMoney = inputMoney();
        }

        return inputMoney;
    }

    public int inputMoney(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("구매금액은 정수만 입력 가능합니다.");
            return inputMoney();
        }
    }

    public boolean normal(int money) {
        if (money <= LottoConstants.ZERO)
            return false;

        return money % LottoConstants.LOTTO_PRICE == LottoConstants.ZERO;
    }
}
