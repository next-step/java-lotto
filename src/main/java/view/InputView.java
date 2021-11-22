package view;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력할수 있습니다.";
    private static final String LAST_WEEK_LOTTERY_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요. (번호는 ',' 로 구분)";
    private static final String COMMA = ",";
    private static final String NULL_ERROR_MESSAGE = "error : Null 값은 입력할수 없습니다.";
    private static final String EMPTY_ERROR_MESSAGE = "error : 공백 은 입력할수 없습니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);

        return validNumber();
    }

    public static Set<Integer> inputLastWeekNumber() {
        System.out.println(LAST_WEEK_LOTTERY_NUMBER_MESSAGE);

        return removeOverlap(scanner.nextLine());
    }

    public static int inputBonusBall() {
        System.out.println("보너스볼 을 입력해 주세요.");

        return validNumber();
    }

    private static int validNumber() {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }

    private static Set<Integer> removeOverlap(String text) {
        checkTextNull(text);
        checkTextEmpty(text);
        return Arrays.stream(text.split(COMMA))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toSet());
    }

    private static void checkTextNull(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkTextEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

}
