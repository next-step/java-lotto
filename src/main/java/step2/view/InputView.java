package step2.view;

import step2.domain.Lottery;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println(String.format("%d개를 구매했습니다.", input / 1000));

        return input;
    }

    public static String inputLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
