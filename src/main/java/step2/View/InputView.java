package step2.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int moneyInput() {
        System.out.println("구입금액을 입력해주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public int manualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public String lastWeekWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }

    public int lastWeekBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> manualLottoList(int manualLottoCount) {
        List<String> manualLottoList = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        for (int idx = 0; idx < manualLottoCount; idx++) {
            String manualLottoNumbers = scanner.nextLine();
            manualLottoList.add(manualLottoNumbers);
        }
        return manualLottoList;
    }

}
