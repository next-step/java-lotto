package autolotto.view;

import java.util.Scanner;

public class InputView {

    public int inputMoney(){
        System.out.println("구입 금액을 입력해주세요.");
        return new Scanner(System.in).nextInt();
    }
}
