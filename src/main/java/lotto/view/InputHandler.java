package lotto.view;

import java.util.Scanner;
import lotto.Constant;

public class InputHandler {

    private final Scanner sc = new Scanner(System.in);

    public String requestPriceFromUser() {
        printRequestPriceFromUser();
        return sc.nextLine();
    }

    public String requestWinningNumber() {
        printRequestWinningNumber();
        return sc.nextLine();
    }

    public String requestBonusNumber() {
        printRequestBonusNumber();
        return sc.nextLine();
    }

    private void printRequestPriceFromUser() {
        System.out.println(Constant.REQUEST_PURCHASE_PRICE);
    }

    private void printRequestWinningNumber() {
        System.out.println(Constant.REQUEST_WINNING_PRICE);
    }

    private void printRequestBonusNumber() {
        System.out.println(Constant.REQUEST_BONUS_BALL);
    }
}
