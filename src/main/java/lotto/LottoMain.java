package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] arg) {
        int inputLottoGames = InputView.inputLotteGames();

        List<Lotto> lottos = new ArrayList <>();
        LottoMachine lottoMachine = new LottoMachine();
        int lottoGameCount = inputLottoGames / 1000;
        for(int i=0; i<lottoGameCount; i++){
            Lotto lotto = new Lotto(lottoMachine.getGameNumber());
            lottos.add(lotto);
        }
        OutputView.printPurchaseLottoNumber(lottos);

        String inputLastWeekLottoNumber = InputView.inputLastWeekLottoNumber();
        for(Lotto lotto : lottos){
            lotto.winnerCheck(inputLastWeekLottoNumber);
        }

        LottoGames lottoGames = new LottoGames(lottos);
   }
}
