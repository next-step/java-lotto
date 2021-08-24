package com.techmoa.lotto.view;

import com.techmoa.lotto.service.LottoAnswer;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static int purchaseAmount = 0;
    private static LottoAnswer lottoAnswer = null;

    public void enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        if(scanner.hasNextLine())
            purchaseAmount = scanner.nextInt();

    }

    public void enterLastWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        if(scanner.hasNextLine())
            lottoAnswer = new LottoAnswer(scanner.nextLine());
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static LottoAnswer getLottoAnswer() {
        return lottoAnswer;
    }
}
