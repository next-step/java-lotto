package ui;

import model.lotto.Lotto;
import model.lotto.Price;
import model.lotto.WinningLotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static model.lotto.LottoType.AUTO;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Price getPayAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int payAmount = SCANNER.nextInt();
        return new Price(payAmount);
    }

    public static WinningLotto getLastWeekWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = SCANNER.nextInt();
        return new WinningLotto(input, bonusBall);
    }

    public static String getInput() {
        return SCANNER.nextLine();
    }

    public static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = SCANNER.nextInt();
        SCANNER.nextLine();
        return count;
    }

    public static List<Lotto> getManualLottoList(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(SCANNER::nextLine)
                .limit(count)
                .map(numbers -> new Lotto(numbers, AUTO))
                .collect(Collectors.toList());
    }
}
