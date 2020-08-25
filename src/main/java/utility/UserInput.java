package utility;

import domain.WinnerNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInput {

    private static final String INIT_MESSEGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSEGE = "개를 구매했습니다.";
    private static final String AFTER_MESSEGE = "지난 당첨번호를 입력하세요.";
    public static final int WON = 1000;
    public static final Scanner SC = new Scanner(System.in);

    private UserInput() {
    }

    public static int init() {
        System.out.println(INIT_MESSEGE);
        int input = SC.nextInt();
        SC.nextLine();

        validatePrice(input);
        input /= WON;
        System.out.println(input + PURCHASE_MESSEGE);

        return input;
    }

    private static void validatePrice(int price) {
        if (price % WON != 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
    }

    public static WinnerNumber getWinnerTicket() {
        String[] winnerNumber = inputWinnerNumber();

        int[] number = Arrays.stream(winnerNumber)
                .mapToInt(Integer::parseInt).toArray();

        return new WinnerNumber(number);
    }

    private static String[] inputWinnerNumber() {
        System.out.println(AFTER_MESSEGE);
        String input = SC.nextLine();
        String[] inputs = input.split(",");

        validate(inputs);
        return inputs;
    }

    private static void validate(String[] inputs) {
        validateNumberIsSix(inputs);
        validateStringsDuplicate(inputs);
        validateNumberRange(inputs);
    }

    static void validateNumberRange(String[] inputs) {
        boolean rangeValidate = Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .allMatch(c -> c <= 45);

        if (!rangeValidate) {
            throw new IllegalArgumentException("숫자 범위 입력 오류!!");
        }
    }

    static void validateStringsDuplicate(String[] inputs) {
        Set<String> set = new HashSet<>(Arrays.asList(inputs));

        if (set.size() != inputs.length) {
            throw new IllegalArgumentException("중복 값 입력 에러!");
        }
    }

    static void validateNumberIsSix(String[] inputs) {
        if (inputs.length != 6) {
            throw new IllegalArgumentException("숫자 개수 에러 ");
        }
    }
}
