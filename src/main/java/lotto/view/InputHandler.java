package lotto.view;

import java.util.Scanner;
import lotto.Constant;

public class InputHandler {

    private Scanner sc = new Scanner(System.in);

    public String requestPriceFromUser(){
        printRequestPriceFromUser();
        return sc.nextLine();
    }

    private void printRequestPriceFromUser() {
        System.out.println(Constant.REQUEST_PURCHASE_PRICE);
    }
}
