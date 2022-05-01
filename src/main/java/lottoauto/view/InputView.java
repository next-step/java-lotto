package lottoauto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int askLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> askWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoString = scanner.nextLine();
        String[] winningLottoSplits = winningLottoString.split(",");
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 0; i < winningLottoSplits.length; i++) {
            winningLotto.add(Integer.parseInt(winningLottoSplits[i]));
        }
        return winningLotto;
    }
}
