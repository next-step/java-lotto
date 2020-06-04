package study.step3.view;

import study.step3.dto.LottoInputDto;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String INSERT_MONEY = "구입 금액을 입력해 주세요.";
    private final static String INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)";
    private final static String INSERT_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";

    private InputView(){}

    public static long inputMoney(){
        System.out.println(INSERT_MONEY);
        return scanner.nextLong();
    }

    public static LottoInputDto inputLastWinningNumbers(){
        return new LottoInputDto(inputWinningNumbers(), inputBonusBall());
    }

    private static int inputBonusBall() {
        System.out.println(INSERT_BONUS_NUMBERS);
        return scanner.nextInt();
    }

    private static String inputWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBERS);
        return scanner.next();
    }
}
