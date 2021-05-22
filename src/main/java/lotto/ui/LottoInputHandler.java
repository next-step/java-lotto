package lotto.ui;

import lotto.domain.wrapper.LottoPurchase;

import java.util.Scanner;

public class LottoInputHandler {
    public LottoPurchase scanLottoPurchaseBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return new LottoPurchase(scanner.nextInt());
    }

    public String scanLottoWinNumbersString() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public int scanLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
