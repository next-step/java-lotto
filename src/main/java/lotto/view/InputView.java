package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
        throw new AssertionError("InputView는 생성자를 호출할 수 없습니다.");
    }

    public static String receiveMoney() {
        System.out.println("로또 금액을 입력해주세요. 로또는 개당 천원입니다.");
        return new Scanner(System.in).nextLine();
    }

    public static List<String> receiveLastWeekWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해 주세요. 콤마로 숫자 6개를 구분해주세요.");
        String lastWeekNumberString = new Scanner(System.in).nextLine();
        String[] lastWeekNumbers = lastWeekNumberString.split(",");
        return Arrays.stream(lastWeekNumbers)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String receiveBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = new Scanner(System.in).nextLine();
        return bonusBall.trim();
    }
}
