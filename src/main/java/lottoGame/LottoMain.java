package lottoGame;

import lottoGame.model.factory.DefaultLottoFactory;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(InputView.print(), new DefaultLottoFactory(), new ResultView());
        lottoGenerator.start();
    }
}
