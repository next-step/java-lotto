package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.ManualLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = scanner.nextLine();
                validateNotEmpty(input);
                return Integer.parseInt(input.trim());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return parseWinningNumbers(input);
    }

    private static Lotto parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return Lotto.from(numbers);
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(Integer.parseInt(scanner.nextLine()));
    }

    public static int inputManualLottoCount() {
        while (true) {
            try {
                System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
                String input = scanner.nextLine();
                validateNotEmpty(input);
                return Integer.parseInt(input.trim());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ManualLottos inputManualLottos(int count) {
        validateCount(count);
        if (count == 0) {
            return new ManualLottos(null);
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            validateNotEmpty(input);
            manualLottos.add(parseWinningNumbers(input));
        }
        return new ManualLottos(manualLottos);
    }

    private static void validateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
