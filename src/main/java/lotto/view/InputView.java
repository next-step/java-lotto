package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer money() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("알맞은 금액을 입력해주세요.");
        }
    }

    public static Integer manual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String manualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String winningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static Integer bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("알맞은 금액을 입력해주세요.");
        }
    }
}
