package step2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        int purchaseAmount = inputView.getPurchaseAmount();

        LottoGame lottoGame = new LottoGame();
        lottoGame.create(purchaseAmount, new ResultView());

        lottoGame.printLottos();

        String lastLottoNumber = inputView.getLastLottoNumber();
        int[] lastLottoNumbers = Arrays.stream(lastLottoNumber.trim().split(", "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        lottoGame.countCorrectNumbers(lastLottoNumbers);
        lottoGame.printStatistics();

    }
}
