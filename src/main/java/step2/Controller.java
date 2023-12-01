package step2;

import static step2.PlayRounds.getPlayRounds;
import static step2.ReturnRate.getReturnRate;

public class Controller {

    public static void main(String[] args) throws RetryFailedException {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int maxRetry = 2;
        int price = 0;
        int rounds = 0;
        int prize = 0;

        while (maxRetry-- > 0 ){

            try {
                price = inputView.inputPrice();
                rounds = getPlayRounds(price);
                PlayLotto playLotto = new PlayLotto(rounds);

                resultView.printLottoCount(rounds);
                playLotto.printLottos();

                prize = playLotto.playLottos(new Lotto(WinningNumber.getWinnerNumberList(inputView.inputWinningNumber())));

                resultView.printWinningStatics();
                playLotto.printWinnings();
                resultView.printResult(getReturnRate(price, prize));

                return;

            }catch (NumberFormatException e){
                System.out.println("입력 오류가 발생했습니다. 다시 입력해주세요.");
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        throw new RetryFailedException();

    }

}
