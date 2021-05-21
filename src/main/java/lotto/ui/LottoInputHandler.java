package lotto.ui;

import lotto.domain.LottoPurchaseBudget;
import lotto.domain.LottoWinNumbers;

import java.util.Scanner;

public class LottoInputHandler {

    public LottoPurchaseBudget scanLottoPurchaseBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return new LottoPurchaseBudget(scanner.nextInt());
    }

    public LottoWinNumbers scanLottoWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return new LottoWinNumbers(scanner.nextLine());
    }

}
