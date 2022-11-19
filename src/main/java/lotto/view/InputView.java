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

    public static int manual() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return SCANNER.nextInt();
    }

    public static Map<Integer, List<String>> manualNumber(int quantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.nextLine();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < quantity; i++) {
            String[] split = SCANNER.nextLine().split(",");
            map.put(i, Arrays.asList(split));
        }
        return map;
    }

    public static Set<String> winningLotto() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        return new HashSet<>(Arrays.asList(SCANNER.nextLine().split(",")));
    }

    public static int bonusLotto() {
        System.out.println("보너스 볼을 입력해주세요");
        return SCANNER.nextInt();
    }
}
