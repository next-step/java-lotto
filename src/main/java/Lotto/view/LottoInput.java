package Lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoInput {

    private static final String ASK_PRICE = "구입금액을 입력해 주세요";
    private static final String ASK_LUCKY_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUMS_BALL = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);


    public static int getPrice() {
        System.out.println(ASK_PRICE);
        int price = Integer.parseInt(SCANNER.nextLine());
        System.out.println(price);
        return price;
    }

    public static List<String> getLuckyNumbers() {
        System.out.println(ASK_LUCKY_NUMBERS);
        return Arrays.asList(SCANNER.nextLine().split(", "));
    }

    public static int getBonusNumber() {
        System.out.println(ASK_BONUMS_BALL);
        return Integer.parseInt(SCANNER.nextLine());
    }

}
