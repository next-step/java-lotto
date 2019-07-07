package step2;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        resultView.countLottoResult(inputView.inputCash());

        String[] inputWinningNumbers = inputView.inputWinningNumbers();  // 공백 제거하지 않은 상테


    }
}
