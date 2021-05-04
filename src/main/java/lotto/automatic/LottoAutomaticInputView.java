package lotto.automatic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoAutomaticInputView {
    Scanner scan = new Scanner(System.in);
    LottoAutomaticResultView resultView = new LottoAutomaticResultView();

    public int inputBuyPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int buyPrice = scan.nextInt();
        return resultView.resultBuyPrice(buyPrice);
    }


    public String inputWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        String winningNumber = scan.nextLine();

        return winningNumber;
    }

    public int inputBonus() {
        System.out.println("보너스 볼을 입력해주세요");
        int bonusNumber = scan.nextInt();

        return bonusNumber;
    }

}
