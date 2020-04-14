package Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public Amount inputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();
        return new Amount(amount);
    }

    public List<Integer> inputPrizeNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String prizeNumber = scanner.nextLine();
        String[] temp = prizeNumber.split(",");

        List<Integer> prizeList = new ArrayList<>();
        for (String s : temp) {
            prizeList.add(Integer.parseInt(s));
        }

        return prizeList;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String bonusNumber = scanner.nextLine();

        return Integer.parseInt(bonusNumber);
    }

}
