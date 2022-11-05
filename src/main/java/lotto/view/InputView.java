package lotto.view;

import lotto.domain.Lotto;
import lotto.LottoFactory;

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
            lottos.add(LottoFactory.createManualLotto(numbers));
        }

        return lottos;
    }

    private static String[] inputAndSplitString() {
        return SCANNER.nextLine().trim().split(COMMA);
    }

    public static List<Integer> inputNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        SCANNER.nextLine();

        try {
            return Arrays.stream(SCANNER.nextLine().split(", "))
                    .map(Integer :: parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");

        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
