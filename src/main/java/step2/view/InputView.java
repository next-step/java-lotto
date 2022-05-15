package step2.view;

import step2.domain.PurchaseCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private static final String START = "[START]";

    private final Scanner scanner;

    public InputView() {
        show(START);
        this.scanner = new Scanner(System.in);
    }

    public int askPurchaseAmount() {
        show("구입금액을 입력해 주세요.");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public List<String> askManualNumbers(PurchaseCount purchaseCount) {
        List<String> result = new ArrayList<>();
        show("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < purchaseCount.getValue(); i++) {
            result.add(this.scanner.nextLine());
        }

        return result;
    }

    public int askManualCount() {
        show("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public String askWinnerInput() {
        show("\n지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.nextLine();
    }

    public String askBonusInput() {
        show("\n보너스볼을 입력해주세요");
        return this.scanner.next();
    }

    private void show(String output) {
        out.println(output);
    }

    public void close() {
        this.scanner.close();
    }
}
