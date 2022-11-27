package lotto.view;

import lotto.model.LottoFactory;

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

    public static List<LottoFactory> manualNumber(int quantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.nextLine();
        List<LottoFactory> factories = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            String[] split = SCANNER.nextLine().split(",");
            factories.add(new LottoFactory(new ArrayList<>(Arrays.asList(split))));
        }
        return factories;
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
