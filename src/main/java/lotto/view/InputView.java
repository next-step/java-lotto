package lotto.view;

import lotto.dto.LottoInput;
import lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }

    public String inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public LottoInput getLottoInput() {
        Money money = getMoney();
        int manualCount = getManualCount();
        List<String> manualLottos = getManualLottos(manualCount);
        return new LottoInput(money, manualCount, manualLottos);
    }

    private List<String> getManualLottos(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(scanner.nextLine());
        }
        return manualLottos;
    }

    private int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = Integer.parseInt(scanner.nextLine());
        return manualCount;
    }

    private Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyString = scanner.nextLine();
        return Money.create(moneyString);
    }
}
