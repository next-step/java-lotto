package lotto;

import java.util.Scanner;

public class InputView {
    Scanner scan;
    private int inputAmount = 0;
    private String inputLastWonLottoNumber;

    InputView() {
        scan = new Scanner(System.in);
    }

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        inputAmount = scan.nextInt();
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void inputLastWonLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        inputLastWonLottoNumber = scan.next();
    }

    public String getInputLastWonLottoNumbers() {
        return inputLastWonLottoNumber;
    }

}
