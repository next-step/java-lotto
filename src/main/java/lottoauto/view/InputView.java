package lottoauto.view;

import lottoauto.domain.Lotto;

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
        return parseLottoNumber();
    }

    private static List<Integer> parseLottoNumber() {
        String lottoString = scanner.nextLine();
        String[] lottoSplits = lottoString.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < lottoSplits.length; i++) {
            lotto.add(Integer.parseInt(lottoSplits[i]));
        }
        return lotto;
    }

    public static int askWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String winningBonusNumberString = scanner.nextLine();
        return Integer.parseInt(winningBonusNumberString);
    }

    public static int askTryManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manualTryCount = scanner.nextLine();
        return Integer.parseInt(manualTryCount);
    }

    public static List<Lotto> inputEachLottos(int tryManualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> returnLottos = new ArrayList<>();
        for (int i = 0; i < tryManualCount; i++) {
            returnLottos.add(new Lotto(parseLottoNumber()));
        }
        return returnLottos;
    }
}
