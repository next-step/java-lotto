package lotto.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);


    public int inputPurchasePrice() {
        System.out.println("구입 금액을 입력해주세요.");

        return inputInteger();
    }

    public int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputInteger();
    }

    public String inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public int inputWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return inputInteger();
    }

    private int inputInteger() {
        int input = SCANNER.nextInt();

        //엔터 제거
        SCANNER.nextLine();

        return input;
    }

}
