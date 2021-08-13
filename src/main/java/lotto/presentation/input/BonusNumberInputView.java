package lotto.presentation.input;

import java.util.Scanner;

public class BonusNumberInputView {

    public static final String BONUS_NUMBER_INPUT_COMMENT = "보너스 볼을 입력해 주세요.";

    public int input(){
        System.out.println(BONUS_NUMBER_INPUT_COMMENT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
