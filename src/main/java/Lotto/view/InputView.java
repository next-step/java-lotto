package Lotto.view;

import Lotto.domain.LottoNumber;
import Lotto.domain.Purchase;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static Lotto.domain.Lottos.LOTTO_PICK_COUNT;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static int askHowMuchYouWouldBuy() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        while(isInvalidPrice(price)) {
            System.out.println("구입은 1000원부터 가능합니다. 금액은 1000원 단위로 입력해 주세요.");
            price = scanner.nextLine();
        }
        return new Purchase(Integer.parseInt(price)).getQuantity();
    };

    private static boolean isInvalidPrice(String price) {
        if (price == null || price.trim().isEmpty()) {
            return true;
        }
        String sanitizedInput = price.replace(",", "");
        return !sanitizedInput.matches("\\d+") || Integer.parseInt(sanitizedInput) <= 0;
    }

    public static Set<LottoNumber> askForWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (e.g. 1, 2, 3, 4, 5, 6)");
        String input = scanner.nextLine();
        while (isInvalidWinningNumbers(input)) {
            System.out.println("올바른 형식으로 입력해 주세요. (예: 1, 2, 3, 4, 5, 6)");
            input = scanner.nextLine();
        }
        return parseWinningNumbers(input);
    }

    private static boolean isInvalidWinningNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        String[] numbers = input.split(",");
        if (numbers.length !=LOTTO_PICK_COUNT) {
            return true;
        }

        return Arrays.stream(numbers)
                .map(String::trim)
                .anyMatch(InputView::isInvalidLottoNumber);
    }

    public static LottoNumber askForBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        while(isInvalidLottoNumber(input)){
            System.out.println("1~45 사이 숫자로 입력해 주세요.");
            input = scanner.nextLine();
        }
        return LottoNumber.of(Integer.parseInt(input));
    }

    private static boolean isInvalidLottoNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number < LottoNumber.LOTTO_MIN_NUMBER || number > LottoNumber.LOTTO_MAX_NUMBER;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static int trimAndReturnInt(String input) {
        return Integer.parseInt(input.trim());
    }

    private static Set<LottoNumber> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
