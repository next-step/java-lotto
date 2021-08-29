package com.techmoa.lotto.view;

import com.techmoa.lotto.service.LottoAnswer;

import java.util.Scanner;

public class InputView {

    private static int purchaseAmount = 0;
    private static String winEnterString ;

    public static void enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt())
            purchaseAmount = scanner.nextInt();
    }

    public static void enterLastWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()) {
            winEnterString = scanner.nextLine();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static String getWinEnterString() {
        return winEnterString;
    }
}
