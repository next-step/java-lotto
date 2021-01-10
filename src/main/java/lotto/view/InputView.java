package lotto.view;

import util.Message;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT_MESSAGE);
        return inputIntScanner();
    }

    public static int inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER_MESSAGE);
        return inputIntScanner();
    }

    private static int inputIntScanner() {
        return SCANNER.nextInt();
    }

    public static String inputPrizeNumbers() {
        System.out.println(Message.LAST_WEEK_WINNER_NUMBER);
        return inputStringScanner();
    }

    private static String inputStringScanner() {
        return SCANNER.next();
    }

    public static String[] inputBuyManualLotto(int coin) {
        System.out.println(Message.INPUT_BUY_MANUAL_LOTTO_COUNT);
        int count = inputIntScanner();
        if(count > coin) {
            throw new RuntimeException("코인 개수보다 구매 개수가 많습니다.");
        }
        return inputManualLottoNumbers(count);
    }

    public static String[] inputManualLottoNumbers(int buyCount) {
        System.out.println(Message.INPUT_BUY_MANUAL_LOTTO_NUMBER);
        String[] manualNumbers = new String[buyCount];
        for(int i=0; i < buyCount; i++) {
            manualNumbers[i] = inputStringScanner();
        }
        return manualNumbers;
    }
}
