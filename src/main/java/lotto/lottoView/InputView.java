package lotto.lottoView;

import java.util.Scanner;

public class InputView {
        static Scanner sc = new Scanner(System.in);

    public static int inputInitCost(){
        System.out.println("구입금액을 입력해 주세요.");
        return(sc.nextInt());
    }

    public static String inputWinNumbers(){
        sc.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return(sc.nextLine());
    }

    public static int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

}
