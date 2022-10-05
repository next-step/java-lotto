package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String BUY_TEXT = "구입금액을 입력해 주세요.";
    public static final Scanner sc = new Scanner(System.in);

    public static int buyLotto() {
        System.out.println(BUY_TEXT);
        return sc.nextInt();
    }

    public static List<Integer> getLastWinner() {
        sc.nextLine();
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요");
        return Arrays.stream(sc.nextLine().replace(" ", "").split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
