package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static lotto.model.Profit.LOTTO_PRICE;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputQuantity() {
        System.out.println("구매금액을 입력해 주세요");
        return SCANNER.nextInt() / LOTTO_PRICE;
    }

    public static List<String> inputWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        SCANNER.nextLine();

        String[] split = SCANNER.nextLine().split(",");
        return new ArrayList<>(Arrays.asList(split));
    }
}
