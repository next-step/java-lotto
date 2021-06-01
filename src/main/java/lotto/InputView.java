package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String START_WORDING = "구입금액을 입력해주세요";

    private static final String LAST_WEEK_WIN_NUMBER_WORDING = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_WORDING = "보너스 볼을 입력해 주세요.";


    public static int getBuyingMoney() {
        System.out.println(START_WORDING);
        String input = SCANNER.nextLine();
        int inputNumber = Integer.parseInt(input);
        if (inputNumber <= 0) {
            throw new RuntimeException("구매 급액은 0보다 커야합니다.");
        }
        return inputNumber;
    }

    public static String getLastWeekWinNumber() {
        System.out.println(LAST_WEEK_WIN_NUMBER_WORDING);
        String input = SCANNER.nextLine();
        return input;
    }

    public static int getBonusWinNumber() {
        System.out.println(BONUS_NUMBER_WORDING);
        String input = SCANNER.nextLine();
        int number = Integer.parseInt(input);
        validateLottoNumber(number);
        return number;
    }

    public static List<Integer> convertWinNumberStringToIntegerList(String winNumber) {
        String[] splitString = winNumber.split(",");
        List<Integer> winNumberList = new ArrayList<>();
        for (int i = 0; i < splitString.length; i++) {
            int number = Integer.parseInt(splitString[i]);
            validateLottoNumber(number);
            winNumberList.add(number);
        }
        return winNumberList;
    }

    private static void validateLottoNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new RuntimeException("로또번호는 1~45사이여야합니다.");
        }
    }


}
