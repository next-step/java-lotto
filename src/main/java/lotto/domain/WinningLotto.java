package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto(String[] winningNumberArr){
        this.winningLotto = getWinningLotto(winningNumberArr);
    }
    public Rank countWinningNumber(Lotto lotto){
        Count winningNumberCount = lotto.match(winningLotto);

        return Rank.valueOf(winningNumberCount);
    }

    private Lotto getWinningLotto(String[] winningNumberArr){
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(String s : winningNumberArr){
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(s)));
        }

        return new Lotto(lottoNumbers);
    }
}
