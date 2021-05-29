package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String START_WORDING = "구입금액을 입력해주세요";

    private static final String LAST_WEEK_WIN_NUMBER_WORDING = "지난 주 당첨 번호를 입력해 주세요.";


    public static int getBuyingMoney() {
        System.out.println(START_WORDING);
        String input = SCANNER.nextLine();
        return Integer.parseInt(input);
    }

    public static String getLastWeekWinNumber() {
        System.out.println(LAST_WEEK_WIN_NUMBER_WORDING);
        String input = SCANNER.nextLine();
        return input;
    }

    public static List<Integer> convertWinNumberStringToIntArray(String winNumber) {
        String[] splitString = winNumber.split(",");
        List<Integer> winNumberList = new ArrayList<>();
        for (int i = 0; i < splitString.length; i++) {
            winNumberList.add(Integer.parseInt(splitString[i]));
        }
        return winNumberList;
    }
}
