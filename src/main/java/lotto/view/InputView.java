package lotto.view;

import java.util.List;
import java.util.Scanner;
import lotto.domain.WinningBall;
import lotto.factory.WinningBallFactory;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<WinningBall> getWinningBalls() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");

        System.out.println("보너스 볼을 입력해 주세요.");
        return WinningBallFactory.of(numbers, scanner.nextLine());
    }
}
