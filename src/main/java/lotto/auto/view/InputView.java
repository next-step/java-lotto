package lotto.auto.view;

import lotto.auto.vo.WinNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String SPLIT_STRING = ", ";
    Scanner scanner = new Scanner(System.in);

    public int requestMoney() {
        System.out.println(REQUEST_PRICE_MESSAGE);
        String money = scanner.nextLine();
        return Integer.parseInt(money);
    }

    public WinNumber requestWinNumber() {
        System.out.println(REQUEST_WIN_NUMBER_MESSAGE);
        String result = scanner.nextLine();
        String[] splitResults = result.split(SPLIT_STRING);
        return new WinNumber(Arrays.stream(splitResults).map(Integer::parseInt).collect(Collectors.toList()));
    }


}
