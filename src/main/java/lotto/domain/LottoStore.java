package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public Lottos sold(BigDecimal price){
        Lottos lottos = new Lottos();
        int amount = price.divide(Lotto.PRICE).intValue();

        for(int i = 0 ; i < amount ; i ++){
            lottos.add(LottoFactory.create());
        }

        return lottos;
    }

    public Winners getWinner(Lottos lottos, String[] winningNumbers){
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        return lottos.getWinner(winningLotto);
    }

    private Lotto getWinningLotto(String[] winningNumberArr){
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(String s : winningNumberArr){
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(s)));
        }

        return new Lotto(lottoNumbers);
    }
}