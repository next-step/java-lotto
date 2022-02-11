package lotto.view;

import java.util.List;
import java.util.Scanner;
import lotto.domain.Parser;

public class InputView {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PRICE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING__NUMBER_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String NEED_OVER_LOTTO_PRICE = "1000원 이상의 금액을 입력해주세요.";
    private static final String NEED_INTEGER = "정수를 입력해주세요.";
    private static final int PRICE_OF_A_LOTTO = 1000;
    
    public static int getPrice() {
        System.out.println(PRICE_INPUT_GUIDE_MESSAGE);
        String priceString = scanner.next();
        int price = validateIsNumber(priceString);
        validatePrice(price);
        return price;
    }
    
    private static void validatePrice(int price) {
        if (price < PRICE_OF_A_LOTTO) {
            throw new IllegalArgumentException(NEED_OVER_LOTTO_PRICE);
        }
    }
    
    private static int validateIsNumber(String priceString) {
        try {
            return Integer.parseInt(priceString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NEED_INTEGER);
        }
    }
    
    public static List<Integer> getWinningNumber() {
        List<Integer> winningNumbers;
        System.out.println(WINNING__NUMBER_INPUT_GUIDE_MESSAGE);
        String numbersString = scanner.next();
        winningNumbers = Parser.parseWinningNumber(numbersString);
        return winningNumbers;
    }
    
    public static int getBonusBall() {
        System.out.println(BONUS_BALL_INPUT_GUIDE_MESSAGE);
        return scanner.nextInt();
    }
}
