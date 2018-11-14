package lotto.view;

import lotto.domain.WInningLottoRequest;
import lotto.domain.LottoRequest;
import lotto.domain.Money;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    
    private static int inputTryNo(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    private static String inputTryLine(String message) {
        System.out.println(message);
        return scanner.next();
    }

    private static String[] inputTryLines(String message, int tryManualLottoCount) {
        if (tryManualLottoCount > 0) {
            System.out.println(message);
            String[] lines = new String[tryManualLottoCount];
            for (int i = 0; i < tryManualLottoCount; i++) {
                lines[i] = scanner.next();
            }
            return lines;
        }
        return null;
    }

    public static LottoRequest inputTryLottoRequest() {
        Money won = Money.of(inputTryNo("구입금액을 입력해 주세요."));
        int tryManualLottoCount = inputTryNo("수동으로 구매할 로또 수를 입력해 주세요.");
        String[] manualLottoValues = inputTryLines("수동으로 구매할 번호를 입력해 주세요.", tryManualLottoCount);
        return new LottoRequest(won, manualLottoValues);
    }

    public static WInningLottoRequest inputTryWinningLottoRequest() {
        String winningNumber = inputTryLine("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = inputTryNo("보너스 볼을 입력해 주세요.");
        return new WInningLottoRequest(winningNumber, bonusNumber);
    }
}
