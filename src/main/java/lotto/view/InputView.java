package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Parser;

public class InputView {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PRICE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String NEED_RIGHT_COUNT = "올바른 로또 수를 입력해 주세요.";
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
    
    public static int inputManualLottoCount(int count) {
        System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
        return validateManualCount(count, scanner.nextInt());
    }
    
    private static int validateManualCount(int count, int manualCount) {
        if (count > manualCount) {
            throw new IllegalArgumentException(NEED_RIGHT_COUNT);
        }
        return manualCount;
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
    
    public static List<Lotto> inputManualLottos(int manualCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            List<String> numbersString = Arrays.asList(scanner.nextLine().split(", "));
            List<Integer> numbers = numbersString.stream().map(string -> Integer.parseInt(string))
              .collect(
                Collectors.toList());
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
