package lotto.view;

import lotto.model.WinningResult;
import lotto.model.LottoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoManualView {

    public int inputPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int inputManualLottoQuantity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<String> inputManualLottoNumbers(int manualQuantity) {
        Scanner scanner = new Scanner(System.in);

        List<String> manualNumbers = new ArrayList<>();

        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualQuantity; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public void printLottos(int manualQuantity, int autoQuantity, List<LottoModel> lottos) {
        System.out.println();
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로 " + autoQuantity + "개를 구매했습니다.");
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

    public void outputWinningStatistics(float earningRate) {
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
