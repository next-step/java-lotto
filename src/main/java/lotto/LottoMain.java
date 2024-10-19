package lotto;

import random.LottoGenerateStrategy;
import random.LottoGenerator;
import random.RandomLottoNumbers;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int perchaseAmount = scanner.nextInt();
        scanner.nextLine();

        Lotto lotto = Lotto.InitLotto();
        System.out.println(lotto.calculateLottoTryCount(perchaseAmount) + "개를 구매했습니다.");
        LottoGenerator lottoGenerator = new LottoGenerateStrategy(new RandomLottoNumbers());
        lotto.makeLottoList(lottoGenerator);
        lotto.printLottoList();

        System.out.println("지난주 당첨 번호를 입력해주세요");
        String lottoWinnerNumbers = scanner.nextLine();
        LottoWinner lottoWinner = new LottoWinner(lottoWinnerNumbers);

        lotto.runWinner(lottoWinner);
        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoWinner.printMatchingCount();
        int winningAmount = lottoWinner.winningAmount();
        ProfitMargin profitMargin = new ProfitMargin(winningAmount, perchaseAmount);
        profitMargin.printMargin();
    }

}
