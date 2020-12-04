package lotto.automatic.view;

import lotto.automatic.domain.WinningLotto;
import lotto.automatic.dto.LottoBuyingMoney;
import lotto.automatic.dto.ManualLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public LottoBuyingMoney getLottoMoney() {

        System.out.println("구입 금앱을 입력해주세요");
        int money = getInt();

        return new LottoBuyingMoney(money);
    }

    public ManualLottos getManualLottos(int totalCountOfLotto) {
        List<String> stringInputs = new ArrayList<>();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualAmount = getInt();

        ManualLottos.validateManualLottoCountWithTotalCount(totalCountOfLotto, manualAmount);

        if(manualAmount > 0 ) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            for(int i = 0; i < manualAmount; i++) {
                stringInputs.add(getString());
            }
        }

        return new ManualLottos(manualAmount, stringInputs);
    }

    public WinningLotto getWinningLottoNums() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String rawNumberString = getString();

        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = getInt();

        return new WinningLotto(rawNumberString, bonusNumber);
    }

    private int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
