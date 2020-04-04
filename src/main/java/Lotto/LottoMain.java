package Lotto;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoProgress lottoProgress = new LottoProgress();
        ResultView resultView = new ResultView();

        Amount amount = inputView.InputPurchasingAmount();

        int quantity = lottoProgress.amountToQuantity(amount);
        resultView.showQuantity(quantity);
        LottoBundle lottoBundle = new LottoBundle(quantity);
        resultView.showLottoNumbers(lottoBundle);

    }


}
