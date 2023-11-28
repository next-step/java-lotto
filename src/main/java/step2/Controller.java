package step2;

import static step2.PlayRounds.getPlayRounds;
import static step2.ReturnRate.getReturnRate;

public class Controller {

    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int price = 0;
        int rounds = 0;
        int prize = 0;

        try {
            price = inputView.inputPrice();
            rounds = getPlayRounds(price);
            PlayLotto playLotto = new PlayLotto(rounds);

            resultView.printLottoCount(rounds);
            playLotto.printLottos();

            int[] winningNumbers = WinningNumber.getWinnerNumberList(inputView.inputWinningNumber());
            prize = playLotto.playLottos(winningNumbers);

            resultView.printWinningStatics();
            playLotto.printWinnings();
            resultView.printResult(getReturnRate(price, prize));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
