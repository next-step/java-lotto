import java.util.List;
import java.util.Scanner;

public class LottoAutoView {
    Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printLotto(int quantity, List<LottoAutoModel> lottos) {
        System.out.println(quantity + "개를 구매했습니다.");
        for (LottoAutoModel lotto : lottos) {
            System.out.println(lotto.getAutoNumbers());
        }
    }

    public String inputWinningNumbers() {
        System.out.println("winning numbers 지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputBonusNumber() {
        System.out.println("bonus number 보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public void outputWinningStatistic(double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + LottoAutoController.winningResult.fifth.numberOfWinnings + "개");
        System.out.println("4개 일치 (50000원)- " + LottoAutoController.winningResult.fourth.numberOfWinnings + "개");
        System.out.println("5개 일치 (1500000원)- " + LottoAutoController.winningResult.third.numberOfWinnings + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + LottoAutoController.winningResult.second.numberOfWinnings + "개");
        System.out.println("6개 일치 (2000000000원)- " + LottoAutoController.winningResult.first.numberOfWinnings + "개");

        System.out.println("총 수익률은 " + earningRate + "입니다.");
    }
}
