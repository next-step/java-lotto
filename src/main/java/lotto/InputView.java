package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static int enterBuyPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> enterWinningLottoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(numbers, ", ");
        List<Integer> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return list;
    }

    public static int enterBonusBall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

}
