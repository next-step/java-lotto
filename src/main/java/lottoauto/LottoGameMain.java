package lottoauto;

public class LottoGameMain {
    public static void main(String[] args) {
        Lottos lottos = Lottos.from(InputView.inputPurchaseAmount());
        ResultView.printLottosInfo(lottos);

        Lotto winningLotto = Lotto.from(InputView.inputWinningNumbers());
        RatingStatics ratingStatics = lottos.findRatingStatics(WinningLotto.from(winningLotto));
        ResultView.printRatingStatics(ratingStatics);
        ResultView.printRateOfReturn(ratingStatics.rateOfReturn(lottos.totalPrice()));
    }
}
