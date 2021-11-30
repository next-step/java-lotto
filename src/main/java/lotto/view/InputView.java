package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_PRICE = "구입금액을 입력해 주세요.";

    public String questionPrice() {
        System.out.println(INSERT_PRICE);

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }


}
