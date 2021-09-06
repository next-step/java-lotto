package step2.view;

import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    private final Scanner scanner = new Scanner(System.in);

    public InputDto inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        final int price = Integer.parseInt(scanner.nextLine());

        return new InputDto(getNumberOfPurchases(price));
    }

    public static int getNumberOfPurchases(int price) {
        return price / LOTTO_PRICE;
    }

    public LottoNumbers inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String inputLastWeekWinningNumbers = scanner.nextLine();
        return new LottoNumbers(convertStringToListOfNumber(inputLastWeekWinningNumbers));
    }

    public static List<Integer> convertStringToListOfNumber(String input) {
        final String[] split = input.replaceAll(" ", "").split(",");
        return Arrays.stream(split)
                .map(Integer::valueOf)
                .collect(Collectors
                        .toList());
    }

    public LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(scanner.nextLine()));
    }
}
