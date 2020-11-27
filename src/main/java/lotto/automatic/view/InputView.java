package lotto.automatic.view;

import lotto.automatic.domain.LottoMoney;
import lotto.automatic.domain.LottoWinningNums;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public LottoMoney getLottoMoney() {

        System.out.println("구입 금앱을 입력해주세요");
        int money = scanner.nextInt();
        return new LottoMoney(money);
    }

    public LottoWinningNums getWinningLottoNums() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String rawNumberString = scanner.nextLine();
        scanner.close();

        return new LottoWinningNums(rawNumberString);
    }
}
