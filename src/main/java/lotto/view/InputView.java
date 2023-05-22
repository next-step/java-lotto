package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int enterAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] split = new Scanner(System.in).nextLine().split(", ");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static Integer enterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

}
