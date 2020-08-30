package step4.view;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int receiveMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static String[] receiveManualLottoNosLines() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoNosCount = scanner.nextInt();
        String[] manualLottoNoLines = new String[manualLottoNosCount];
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner.nextLine();
        IntStream.range(0, manualLottoNosCount)
                .forEach(count -> manualLottoNoLines[count] = scanner.nextLine());
        return manualLottoNoLines;
    }

    public static String receiveWinningNumberLine() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int receiveBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

}
