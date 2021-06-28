package lottogame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public int inputBuyPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scan.nextInt();
    }

    public int inputManualBuyPrice() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scan.nextInt();
    }

    public List<String> inputManualLotto(int manualBuyCouny) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualBuyCouny; i++) {
            manualLottoList.add(scan.next());
        }
        return manualLottoList;
    }

    public String inputWinningLottoNumber() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return scan.next();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return scan.nextInt();
    }

}
