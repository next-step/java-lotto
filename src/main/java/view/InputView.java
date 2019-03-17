package view;

import domain.Lotto;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumberOfLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        String numberOfLottos = scanner.nextLine();
        int result = Integer.parseInt(numberOfLottos) / 1000;
        System.out.println(result + "개를 구매했습니다.");

        return result;
    }

    public static Lotto getWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winLotto = scanner.nextLine();

        return new Lotto(winLotto.split(","));
    }
}
