package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CheckWinning {

    Lotto winningLotto;
    List<Lotto> lottoList;

    public CheckWinning(Lotto winningLotto, List<Lotto> lottoList) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
    }

    public CheckWinning(Lotto winningLotto) {
        this(winningLotto,null);
    }

    public Lotto setWinningNubmer(Lotto buyLotto) {
        int winningNCount = (int)buyLotto.getLottoNumber().stream()
                .filter(number -> winningLotto.getLottoNumber().contains(number))
                .count();
        return new Lotto(buyLotto.getLottoNumber(),winningNCount);
    }

    public List<Lotto> setWinningNumberLottoList() {
        for(int i = 0; i < lottoList.size(); i++) {
            Lotto lotto = lottoList.get(i);
            lottoList.set(i,setWinningNubmer(lotto));
        }
        return lottoList;
    }
}
