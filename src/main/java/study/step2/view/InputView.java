package study.step2.view;

import java.util.Scanner;

import study.step2.domain.dto.PurchaseAmount;

public class InputView {

    public static PurchaseAmount input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseAmount(scanner.nextInt());
    }
}
