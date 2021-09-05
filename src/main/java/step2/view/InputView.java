package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    private final Scanner scanner = new Scanner(System.in);

    public InputDto inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        final String inputPrice = scanner.nextLine();
        final Integer price = Integer.valueOf(inputPrice);

        return new InputDto(price, getNumberOfPurchases(price));
    }

    public static int getNumberOfPurchases(int price) {
        return price / LOTTO_PRICE;
    }

    public List<Integer> inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String inputLastWeekWinningNumbers = scanner.nextLine();
        return convertStringToListOfNumber(inputLastWeekWinningNumbers);
    }

    public static List<Integer> convertStringToListOfNumber(String input) {
        final String[] split = input.replaceAll(" ", "").split(",");
        return Arrays.stream(split)
                .map(Integer::valueOf)
                .collect(Collectors
                        .toList());
    }
}
