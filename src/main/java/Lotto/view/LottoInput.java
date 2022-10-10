package Lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoInput {

    private static final String ASK_PRICE = "구입금액을 입력해 주세요";
    private static final Scanner SCANNER = new Scanner(System.in);


    public static int getPrice() {
        System.out.println(ASK_PRICE);
        int price = Integer.parseInt(SCANNER.nextLine());
        System.out.println(price);
        return price;
    }

    public static List<String> getLuckyNumbers(){
        return Arrays.asList(SCANNER.nextLine().split(", "));
    }
}
