package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_JACKPOT_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return scanner.nextInt();
    }

    public List<Integer> readJackpotNumber() {
        System.out.println(INPUT_JACKPOT_NUMBER_MESSAGE);
        scanner.nextLine();
        String next = scanner.nextLine();
        next = trimAll(next);


        return convertInteger(next);
    }

    public int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    private List<Integer> convertInteger(String text) {
        return Arrays.stream(split(text))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] split(String text) {
        return text.split(",");
    }

    private String trimAll(String next) {
        return next.replace(" ", "");
    }
}
