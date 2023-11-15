package lottoView;

import lotto.LottoGame;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요." );
        String text = SCANNER.nextLine();
        return LottoGame.convertNum(text);
    }

    public static String lastLottoNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요." );
        return SCANNER.nextLine();
    }
}
