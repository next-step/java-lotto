package step4.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int askQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int askNumberOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void askManualLottoValue() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner.skip("\\R");
    }

    public static int numberOfAutomaticLottoTrials(int amount, int numberOfManualLottoTrials) {
        int numberOfAutomaticLotto = (amount / 1000) - numberOfManualLottoTrials;
        System.out.println("수동으로 " + numberOfManualLottoTrials + "장, 자동으로 " + numberOfAutomaticLotto + "개를 구매했습니다.");
        return numberOfAutomaticLotto;
    }

    public static String checkWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int checkBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String enterManualLottoNumber() {
        return scanner.nextLine();
    }
}
