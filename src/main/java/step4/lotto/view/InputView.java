package step4.lotto.view;

import java.util.Scanner;
import step4.lotto.model.Count;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getManualLottoTicketCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 장수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public void printManualLottoNumbersTitle() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String getManualLottoNumbers() {
        return scanner.nextLine();
    }

    public String getLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

}
