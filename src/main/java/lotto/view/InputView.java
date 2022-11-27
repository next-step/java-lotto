package lotto.view;


import java.util.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int buyPrice() {
        System.out.println("구매금액을 입력해 주세요");
        return SCANNER.nextInt();
    }

    public static int manualQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return SCANNER.nextInt();
    }

    public static void printRequestToInput() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.nextLine();
    }

    public static List<String> manualNumber() {
        return new ArrayList<>(Arrays.asList(SCANNER.nextLine().split(",")));
    }

    public static List<String> winningLotto() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        return new ArrayList<>(Arrays.asList(SCANNER.nextLine().split(",")));
    }

    public static int bonusLotto() {
        System.out.println("보너스 볼을 입력해주세요");
        return SCANNER.nextInt();
    }
}
