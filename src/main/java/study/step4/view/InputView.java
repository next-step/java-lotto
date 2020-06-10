package study.step4.view;

import study.step4.domain.WinningLotto;
import study.step4.dto.LottoInputDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String INSERT_MONEY = "구입 금액을 입력해 주세요.";
    private final static String INSERT_MANUAL_AMOUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String INSERT_MANUAL_NUMBERS = "수동으로 구매할 로또 번호를 입력해 주세요.";
    private final static String INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)";
    private final static String INSERT_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";
    private final static int ZERO_INDEX = 0;

    private InputView(){}

    public static long inputMoney(){
        System.out.println(INSERT_MONEY);
        return scanner.nextLong();
    }

    public static WinningLotto inputLastWinningNumbers(){
        return new WinningLotto(inputWinningNumbers(), inputBonusBall());
    }

    private static int inputBonusBall() {
        System.out.println(INSERT_BONUS_NUMBERS);
        return scanner.nextInt();
    }

    private static String inputWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBERS);
        return scanner.next();
    }

    public static int inputManualAmount() {
        System.out.println(INSERT_MANUAL_AMOUNT);
        return scanner.nextInt();
    }

    public static LottoInputDto inputLottoValues() {
        long price = inputMoney();
        int manualAmount = inputManualAmount();
        List<String> inputNumbers = inputManualNumbers(manualAmount);
        return new LottoInputDto(price, manualAmount, inputNumbers);
    }

    static List<String> inputManualNumbers(int manualAmount) {
        List<String> inputNumbers = new ArrayList<>();
        System.out.println(INSERT_MANUAL_NUMBERS);
        for (int i = ZERO_INDEX; i < manualAmount; i++){
            inputNumbers.add(scanner.next());
        }
        return inputNumbers;
    }
}
