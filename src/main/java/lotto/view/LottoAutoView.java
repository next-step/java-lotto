package lotto.view;

import lotto.model.WinningResult;
import lotto.model.LottoModel;

import java.util.List;
import java.util.Scanner;

public class LottoAutoView {

    public int inputPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printLotto(int quantity, List<LottoModel> lottos) {
        System.out.println(quantity + "개를 구매했습니다.");
        for (LottoModel lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public void outputWinningStatistic(float earningRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + WinningResult.getNumberOfFifthPlace() + "개");
        System.out.println("4개 일치 (50000원)- " + WinningResult.getNumberOfFourthPlace() + "개");
        System.out.println("5개 일치 (1500000원)- " + WinningResult.getNumberOfThirdPlace() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + WinningResult.getNumberOfSecondPlace() + "개");
        System.out.println("6개 일치 (2000000000원)- " + WinningResult.getNumberOfFirstPlace() + "개");

        System.out.print("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.");
        if (earningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
