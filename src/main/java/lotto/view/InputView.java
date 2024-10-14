package lotto.view;

import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.sales.LottoBill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public LottoBill lottoBill() {
        int money = salesAmount();
        int manualCount = manualCount();
        LottoBill bill = new LottoBill(money, manualCount);

        clear();
        return bill;
    }

    private int salesAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return SCANNER.nextInt();
    }

    private int manualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public List<String> manuals(int manualCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요. [" + manualCount + "]");
        List<String> manuals = new ArrayList<>();
        if (manualCount == 0) {
            return manuals;
        }

        for (int i = 0; i < manualCount; i++) {
            manuals.add(SCANNER.nextLine());
        }
        return manuals;
    }

    public Lotto lastWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(SCANNER.nextLine());
    }

    public LottoNumber bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(SCANNER.nextInt());
    }

    private void clear() {
        if (SCANNER.hasNextLine()) {
            SCANNER.nextLine();
        }
    }
}
