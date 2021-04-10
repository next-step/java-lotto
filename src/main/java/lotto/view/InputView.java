package lotto.view;

import lotto.common.LottoConstants;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int count(){

        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = inputMoney();

        while (!normal(inputMoney)) {
            System.out.println("금액을 천원 단위로 입력 하세요.");
            inputMoney = inputMoney();
        }

        return inputMoney;
    }

    public int inputMoney(){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("구매금액은 정수만 입력 가능합니다. 구매 금액을 다시 입력해 주세요.");
            scanner = new Scanner(System.in);
            return inputMoney();
        }
    }

    public String numbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public boolean normal(int money) {

        if (money <= LottoConstants.ZERO) {
            return false;
        }
        return money % LottoConstants.LOTTO_PRICE == LottoConstants.ZERO;
    }

    public int bonusBall() {

        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            return bonusBall(scanner.nextInt());
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("보너스 볼은 정수만 입력 가능합니다.");
            scanner = new Scanner(System.in);
            return bonusBall();
        }
    }

    public int bonusBall(int bonusBall){

        if ((bonusBall > LottoConstants.MAX_LOTTO_NUMBER) || (bonusBall < LottoConstants.MIN_LOTTO_NUMBER)) {
            System.out.printf("보너스 볼은 %d ~ %d 사이여야 합니다.\n", LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER);
            return bonusBall();
        }

        return bonusBall;
    }

    public int manualBuyCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("수동 구매 개수는 정수만 입력 가능합니다.");
            scanner = new Scanner(System.in);
            return manualBuyCount();
        }
    }

    public List<String> manualBuy(int manualBuyCount) {

        scanner.nextLine();
        List<String> manualBuyCounts = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        for (int i = 0; i < manualBuyCount; i++) {
            manualBuyCounts.add(scanner.nextLine());
        }
        System.out.println();
        return manualBuyCounts;
    }
}
