package view.input;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinnerLottoNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] nums = scanner.nextLine().split(",");
        return Stream.of(nums)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(scanner.next());
    }

}
