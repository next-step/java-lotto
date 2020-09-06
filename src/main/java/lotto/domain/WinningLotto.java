package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonumsNumber;

    public WinningLotto(String[] winningNumberArr, int bonumsNumber){
        this.winningLotto = getWinningLotto(winningNumberArr);
        this.bonumsNumber = LottoNumber.of(bonumsNumber);
    }

    public Rank countWinningNumber(Lotto lotto){
        Count winningNumberCount = lotto.match(winningLotto);
        boolean isContainsBonumsNumber = lotto.isContains(bonumsNumber);
        return Rank.valueOf(winningNumberCount, isContainsBonumsNumber);
    }

    private Lotto getWinningLotto(String[] winningNumberArr){
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(String s : winningNumberArr){
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(s)));
        }

        return new Lotto(lottoNumbers);
    }
}
