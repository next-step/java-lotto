package lotto;

import java.util.List;
import java.util.Scanner;

public class LottoController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();

        InputView inputView = new InputView(purchaseAmount);
        int purchaseCount = inputView.getPurchaseCount();
        System.out.println(purchaseCount + "를 구매 했습니다.");

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseCount);
        lottoGenerator.createLottoNumbersByPurchaseCount();
        List<LottoNumber> lottoNumbers = lottoGenerator.getLottoNumbers();

        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getNumbers());
        }

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.next();

        ResultView resultView = new ResultView(winningNumbers, lottoNumbers);
        System.out.println(resultView.printWinningResult());
        double revenuePercent = resultView.calculateRevenuePercent(resultView.totalWinningAmount(),
                                                                   resultView.totalPurchaseAmount());
        System.out.print(revenuePercent);
        if (revenuePercent < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

    }
}
