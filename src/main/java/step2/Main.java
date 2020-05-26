package step2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        int purchaseAmount = inputView.getPurchaseAmount();

        LottoGame lottoGame = new LottoGame();
        lottoGame.create(purchaseAmount);

        lottoGame.printLottos(new ResultView());

        String lastLottoNumber = inputView.getLastLottoNumber();
        String[] lastLottoNumbers = lastLottoNumber.trim().split(", ");
        int[] ints = Arrays.stream(lastLottoNumbers)
                            .mapToInt(Integer::parseInt)
                            .toArray();

        lottoGame.print(ints);
    }
}
