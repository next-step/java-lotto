package Lotto.view;

import Lotto.domain.LottoNumber;
import Lotto.domain.Purchase;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static Lotto.validation.Validations.isInvalidPrice;
import static Lotto.validation.Validations.isInvalidWinningNumbers;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int askHowMuchYouWouldBuy() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        while(isInvalidPrice(price)) {
            System.out.println("구입은 1000원부터 가능합니다. 금액은 1000원 단위로 입력해 주세요.");
            price = scanner.nextLine();
        }
        return new Purchase(Integer.parseInt(price)).getQuantity();
    };

    public static Set<LottoNumber> askForWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (e.g. 1, 2, 3, 4, 5, 6)");
        String input = scanner.nextLine();
        while (isInvalidWinningNumbers(input)) {
            System.out.println("올바른 형식으로 입력해 주세요. (예: 1, 2, 3, 4, 5, 6)");
            input = scanner.nextLine();
        }
        return parseWinningNumbers(input);
    }

    public static int trimAndReturnInt(String input) {
        return Integer.parseInt(input.trim());
    }

    private static Set<LottoNumber> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
