package lotto;

import lotto.domain.LottoBuy;
import lotto.domain.LottoWin;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(scanner.nextLine());

        LottoBuy lottoBuy = new LottoBuy(purchasePrice);

        System.out.println(lottoBuy);

        System.out.println("지난 주 당첨 번호를 입력해주세요");
        String winNumber = scanner.nextLine();

        LottoWin lottoWin = new LottoWin(lottoBuy, winNumber);

        System.out.println(lottoWin);
    }
}
