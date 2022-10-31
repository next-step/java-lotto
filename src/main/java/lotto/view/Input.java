package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.*;

public class Input {
    private static final String WRONG_INPUT = "잘못된 값을 입력 하였습니다.";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ", ";

    private Input() {
    }

    private static String input() {
        return SCANNER.nextLine();
    }

    public static Money inputPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = input();
            System.out.println();
            return new Money(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println(WRONG_INPUT);
            return inputPrice();
        }
    }

    public static int inputManuallyPurchaseCount() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            String input = input();
            System.out.println();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT);
            return inputManuallyPurchaseCount();
        }
    }

    public static Set<Number> inputLottoNumber() {
        try {
            String[] split = input().split(SEPARATOR);

            Set<Number> numbers = new TreeSet<>();
            for (String number : split) {
                numbers.add(Number.of(number));
            }
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT);
            return inputLottoNumber();
        }
    }

    public static Set<Number> inputWinnersNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumber();
    }

    public static Number inputBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            String input = input();
            return Number.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT);
            return inputBonusNumber();
        }
    }

    public static Lottos inputManualLotto(int manuallyPurchaseCount) {
        try {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            List<Lotto> manualLottos = new ArrayList<>();
            for (int i = 0; i < manuallyPurchaseCount; i++) {
                manualLottos.add(new Lotto(Input.inputLottoNumber(), LottoType.MANUAL));
            }
            System.out.println();
            return new Lottos(manualLottos);
        } catch (IllegalArgumentException e) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return inputManualLotto(manuallyPurchaseCount);
        }
    }
}
