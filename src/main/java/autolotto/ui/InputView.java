package autolotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String WIN_NUMBER_PATTERN = ",";
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int buyAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
    }



    private static String checkNllOrBlank(String input) {
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("입력값을 입력하지 않았습니다.");
        }
        return input;
    }

    public static List<Integer> lastWeekWinNumber(){
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : checkNumberCount(checkNllOrBlank(scanner.nextLine()).split(WIN_NUMBER_PATTERN))) {
            winningNumbers.add(validateRange(Integer.parseInt(number.trim())));
        }
        return winningNumbers;
    }

    private static String[] checkNumberCount(String[] split) {
        if(split.length !=6){
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성됩니다. 입력 예)4, 6, 12, 24, 30, 39 ");
        }
        return split;
    }

    private static int validateRange(int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("로또 번호는 1~ 45까지의 숫자 입니다.");
        }
        return number;
    }
}
