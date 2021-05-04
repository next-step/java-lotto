package lotto.automatic;

import java.util.Scanner;

public class LottoAutomaticInputView {
        Scanner scan = new Scanner(System.in);
        LottoAutomaticResultView resultView = new LottoAutomaticResultView();

    public void inputBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int buyPrice = scan.nextInt();

        resultView.resultBuyPrice(buyPrice);
    }

}
