package lotto.service;

import lotto.dao.LottosGenerator;
import lotto.dto.Lotto;
import lotto.dto.Money;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.utils.LottoMaker;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private List<Lotto> gamePlays;

    public LottoGame(Money money2,LottosGenerator lottosGenerator) {
        this.gamePlays = lottosGenerator.genertate(money2);
    }

    public LottoGame(List<Lotto> gamePlays,List<Lotto> gamePlays2) {
        this.gamePlays = gamePlays;
        gamePlays.addAll(gamePlays2);
    }

    public List<Lotto> getGamePlays() {
        return gamePlays;
    }

    public Map<Rank, Integer> match(WinningLotto winnersNum){
        return winnersNum.match(gamePlays);
    }

    public int getGames() {
        return gamePlays.size();
    }

}
