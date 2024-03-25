package lotto.view;

import java.util.Scanner;
import lotto.domain.Lotto;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int inputAmount(){
        System.out.println("로또 구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningLotto(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
