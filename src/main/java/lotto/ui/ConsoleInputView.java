package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView{
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요";
    private static final String MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    public int getPurchaseAmountFromUser(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return SCANNER.nextInt();
    }

    public List<String> getManualLottosFromUser(){
        System.out.println(MANUAL_LOTTO_COUNT_INPUT_MESSAGE);
        int manualLottoCount = SCANNER.nextInt();

        return getManualLottosFromUser(manualLottoCount);
    }

    private List<String> getManualLottosFromUser(int manualLottoCount) {
        System.out.println(MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE);
        List<String> manualLottoNumbers = new ArrayList<>();

        //nextInt() > nextLine() 실행 시 오류 발생 방지
        SCANNER.nextLine();
        for(int i = 0; i < manualLottoCount; i++){
            manualLottoNumbers.add(SCANNER.nextLine());
        }
        return manualLottoNumbers;
    }

    public String getWinningNumbersFromUser(){
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String winningNumbers = SCANNER.nextLine();

        if(winningNumbers.isBlank()){
            throw new IllegalArgumentException("당첨번호를 입력하세요");
        }
        return winningNumbers;
    }

    public int getBonusBallFromUser(){
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
        return SCANNER.nextInt();
    }
}
