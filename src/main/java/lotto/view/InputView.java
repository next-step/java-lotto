package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static String receiveMoney() {
        System.out.println("로또 금액을 입력해주세요. 천원 단위로 입력 해야합니다.");
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
}
