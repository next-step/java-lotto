package utility;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {

    private static final String INIT_MESSEGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSEGE = "개를 구매했습니다.";
    private static final String AFTER_MESSEGE = "지난 당첨번호를 입력하세요.";

    public static int init() {
        System.out.println(INIT_MESSEGE);
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();

        validatePrice(input);
        input /= 1000;
        System.out.println(input+PURCHASE_MESSEGE);

        return input;
    }

    private static void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
    }

    public static int[] getLastWinnerNumber() {
        System.out.println(AFTER_MESSEGE);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] winnerNumber = input.split(",");

        int[] number = Arrays.stream(winnerNumber)
                .mapToInt(Integer::parseInt).toArray();
        return number;
    }
}
