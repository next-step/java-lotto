package lotto.view;

import java.util.Scanner;
import lotto.domain.user.LottoInitInfo;
import lotto.domain.winning.WinningBalls;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static LottoInitInfo getLottoInitInfo() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoInitInfo(Integer.parseInt(scanner.nextLine()));
    }

    public static WinningBalls getWinningBalls() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");

        System.out.println("보너스 볼을 입력해 주세요.");
        return new WinningBalls(numbers, scanner.nextLine());
    }
}
