package lotto.presentation.input;

import lotto.domain.Chance;

import java.util.Scanner;

public class ManualChanceInputView {

    private static final String MANUAL_CHANCE_INPUT_COMMENT  = "수동으로 구매할 로또 수를 입력해주세요.";

    public Chance input(){
        System.out.println(MANUAL_CHANCE_INPUT_COMMENT);
        Scanner scanner = new Scanner(System.in);
        return new Chance(scanner.nextInt());
    }
}
