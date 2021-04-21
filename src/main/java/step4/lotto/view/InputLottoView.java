package step4.lotto.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputLottoView {
    public int inputMoney() throws InputMismatchException {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public int inputManualCount() throws InputMismatchException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public List<String> inputManualNumber(int manualCount) throws InputMismatchException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLotto = new ArrayList<>();
        for(int i =0; i<manualCount; i++){
            manualLotto.add(new Scanner(System.in).nextLine());
        }
        return manualLotto;
    }

    public String inputWinningLotto() throws InputMismatchException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String number = new Scanner(System.in).nextLine();

        return number;
    }

    public int inputBonusNumber() throws InputMismatchException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = new Scanner(System.in).nextInt();
        return number;
    }
}
