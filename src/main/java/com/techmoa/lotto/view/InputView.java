package com.techmoa.lotto.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static int purchaseAmount = 0;
    private static String lastWinnerNumber = null;

    public void enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        if(scanner.hasNextLine())
            purchaseAmount = scanner.nextInt();

    }

    public void enterLastWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        if(scanner.hasNextLine())
            lastWinnerNumber = scanner.nextLine();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public String getLastWinnerNumber() {
        return lastWinnerNumber;
    }
}
