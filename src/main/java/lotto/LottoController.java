package lotto;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int purchaseCount = inputView.getPurchaseCount();
        System.out.println(purchaseCount + "를 구매 했습니다.");

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseCount);
        lottoGenerator.createLottoNumbersByPurchaseCount();
        List<LottoNumber> lottoNumbers = lottoGenerator.getLottoNumbers();

        ResultView resultView = new ResultView();
        String printPurchaseLottoNumbers = resultView.printPurchaseLottoNumbers(lottoNumbers);
        System.out.println(printPurchaseLottoNumbers);

        resultView = new ResultView(lottoNumbers);
        System.out.println(resultView.printWinningResult());
        System.out.println(resultView.printRevenuePercent());

    }
}
