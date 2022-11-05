package lotto.view;

import lotto.Lotto;
import lotto.ManualLottoFactory;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ONLY_NUMBER_EXCEPTION = "숫자만 입력 가능합니다";
    private static final String COMMA = ",";

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_EXCEPTION, e);
        }
    }

    public static int inputManualLottoQuantity() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_EXCEPTION, e);
        }
    }

    public static List<Lotto> inputManualLottoNumbers(int quantity) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            SCANNER.nextLine();

            List<Integer> numbers = Arrays.stream(inputAndSplitString())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            ManualLottoFactory.create(numbers);
        }

        return lottos;
    }

    private static String[] inputAndSplitString() {
        return SCANNER.nextLine().trim().split(COMMA);
    }
}
