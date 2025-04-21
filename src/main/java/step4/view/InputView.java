package step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int init() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<String> inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();
        List<String> manualNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (count > 0) {
            manualNumbers.add(scanner.next());
            count--;
        }
        return manualNumbers;
    }

    public String inputWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextInt();
    }
}
