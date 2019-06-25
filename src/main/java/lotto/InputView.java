package lotto;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    static int inputLotteGames() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    static String inputLastWeekLottoNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputLastWeekBonusNumber() {
        System.out.println("지난 주 보너스 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
