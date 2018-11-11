package game.lotto.view;

import game.lotto.model.LottoNumber;
import game.lotto.model.Money;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money readPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int readValue = Integer.parseInt(scanner.nextLine());

        return new Money(readValue);
    }

    public static String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }

    public static LottoNumber readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int readValue = Integer.parseInt(scanner.nextLine());

        return new LottoNumber(readValue);
    }
}
