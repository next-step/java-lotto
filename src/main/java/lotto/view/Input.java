package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.*;

public class Input {
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
        }catch (NumberFormatException e){
            return inputPrice();
        }
    }

    public static int inputManuallyPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = input();
        System.out.println();
        return Integer.parseInt(input);
    }

    public static Set<Number> inputLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = input();
        String[] split = input.split(SEPARATOR);

        Set<Number> numbers = new TreeSet<>();
        for (String number : split) {
            numbers.add(Number.of(number));
        }
        return numbers;
    }

    public static Number inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = input();
        return Number.of(input);
    }

    public static Lottos inputManualLotto(int manuallyPurchaseCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manuallyPurchaseCount; i++){
            manualLottos.add(new Lotto(Input.inputLottoNumber(), LottoType.MANUAL));
        }
        System.out.println();
        return new Lottos(manualLottos);
    }
}
