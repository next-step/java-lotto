package step3.view;

import com.sun.javafx.robot.FXRobotImage;
import step3.domain.LottoNumber;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public int askTotalPrice() {
        System.out.println("구입금액을 입력해 주세요");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String askWinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public LottoNumber askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        return LottoNumber.of(scanner.nextInt());
    }

    public int askManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String[] askManualLottoNumber(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        String[] inputValue = new String[manualLottoCount];
        for (int i = 0; i < manualLottoCount; i++) {
            inputValue[i] = scanner.nextLine();
        }
        return inputValue;
    }
}
