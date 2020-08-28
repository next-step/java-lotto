package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    // 유틸리티 성격을 가진 클래스이므로 묵시적인 생성자를 방지한다.
    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
//        return Arrays.stream(scanner.nextLine().split(","))
//                .map(number -> Integer.parseInt(number.trim()))
//                .collect(Collectors.toList());
    }

}
