package view;

import java.util.Scanner;

public class InputVeiw {
    private final static int MINIUM_PRICE = 1000;
    private final static int SUBSTR_RANGE = 3;

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (checkPrice(price))
            throw new IllegalArgumentException("최소 금액 1000원 보다 작은 금액이 입력되었습니다. 가격을 다시 한번 입력해주세요.");
        return substringPricetoNumber(price);
    }

    private static boolean checkPrice(int price) {
        return price < MINIUM_PRICE;
    }

    private static int substringPricetoNumber(int price) {
        String priceString = String.valueOf(price);
        return Integer.parseInt(priceString.substring(0, priceString.length() - SUBSTR_RANGE));
    }
}
