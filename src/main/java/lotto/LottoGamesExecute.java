package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGamesExecute {

    private int inputLottoGames;
    private List <Lotto> lottos;

    public LottoGamesExecute(int inputLottoGames) {
        this.inputLottoGames = inputLottoGames;
    }

    public List <Lotto> extractLottoNumbers() {
        lottos = new ArrayList <>();
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 0; i < createLottoGameCount(); i++) {
            lottos.add(new Lotto(lottoMachine.autoLottoNumber()));
        }
        return lottos;
    }

    private int createLottoGameCount() {
        return inputLottoGames / 1000;
    }

    public LottoGames lottoGameResult(String inputLastWeekLottoNumber) {
        for (Lotto lotto : lottos) {
            lotto.winnerCheck(inputLastWeekLottoNumber);
        }
        LottoGames lottoGames = new LottoGames(lottos);
        return lottoGames;
    }
}
