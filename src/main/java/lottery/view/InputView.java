package lottery.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Integer moneyAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String winningNumbersString(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static Integer bonusNumberInteger(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static Long manualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Long.valueOf(SCANNER.nextInt());
    }

    public static List<String> manualNumbersStrings(Long manualLottoCount) {
        SCANNER.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(SCANNER::nextLine)
                .limit(manualLottoCount)
                .collect(Collectors.toList());
    }
}
