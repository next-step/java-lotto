package view;

import util.Console;
import util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SEPARATOR = ",";

    public static int inputMoney() {
        Console.print("구입금액을 입력하세요.");
        try {
            int money = new Scanner(System.in).nextInt();
            if (money < 1000) {
                Console.print("1000원 이상 입력하세요.");
                return 0;
            }
            return money;
        } catch (NumberFormatException e) {
            Console.numberFormatExceptionMessage();
            return 0;
        }
    }

    public static List<Integer> inputWinningNumbers() {
        Console.print("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String [] numbers = new Scanner(System.in).nextLine().split(SEPARATOR);

            if (numbers.length != Constant.MAX_LOTTO_NUMBER_COUNT) {
                Console.print("당첨 번호는 6개 입니다.");
                return Collections.emptyList();
            }

            for (String number : numbers) {
                int lottoNumber = Integer.parseInt(number.trim());
                if (lottoNumber < Constant.MIN_LOTTO_NUMBER || lottoNumber > Constant.MAX_LOTTO_NUMBER) {
                    Console.lottoRangeExceptionMessage();
                    return Collections.emptyList();
                }
                winningNumbers.add(Integer.parseInt(number.trim()));
            }
        } catch (NumberFormatException e) {
            Console.numberFormatExceptionMessage();
            return Collections.emptyList();
        }
        return winningNumbers;
    }

    public static int inputBonusBall() {
        Console.print("보너스 볼을 입력해 주세요.");
        int bonusBall;
        try {
            bonusBall = new Scanner(System.in).nextInt();
            if (bonusBall < Constant.MIN_LOTTO_NUMBER || bonusBall > Constant.MAX_LOTTO_NUMBER) {
                Console.lottoRangeExceptionMessage();
                return 0;
            }
        } catch (NumberFormatException e) {
            Console.numberFormatExceptionMessage();
            return 0;
        }
        return bonusBall;
    }
}
