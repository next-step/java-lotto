package study.lotto.view;


import java.math.BigDecimal;
        import java.util.Scanner;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public BigDecimal inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isRightPrice = false;
        while (!isRightPrice){
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
            input = scanner.next();
            isRightPrice = checkInput(input);
        }
        return BigDecimal.valueOf(Long.parseLong(input));
    }

    private boolean checkInput(String input) {
        return input.chars().allMatch(Character::isDigit) && Long.parseLong(input) >= 1000;
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
