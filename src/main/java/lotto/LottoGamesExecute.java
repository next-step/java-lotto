package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGamesExecute {

    private int inputLottoGames;
    private List<Lotto> lottos;

    public LottoGamesExecute(int inputLottoGames) {
        this.inputLottoGames = inputLottoGames;
    }

    public List<Lotto> extractLottoNumbers() {
        lottos = new ArrayList <>();
        for (int i = 0; i < createLottoGameCount(); i++) {
            lottos.add(new Lotto(LottoMachine.autoLottoNumber()));
        }
        return lottos;
    }

    public LottoGames lottoGameResult(String inputLastWeekLottoNumber) {
        for (Lotto lotto : lottos) {
            lotto.winnerCheck(inputLastWeekLottoNumber);
        }
        LottoGames lottoGames = new LottoGames(lottos);
        return lottoGames;
    }

    private int createLottoGameCount() {
        return inputLottoGames / 1000;
    }

}
