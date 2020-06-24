package lotto;

import lotto.domain.*;
import lotto.utils.LottoShuffle;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private Money money;
    private List<Lotto> lottos;

    public LottoController(Money money) {

        lottos = new ArrayList<Lotto>();
        this.money = money;
    }

    public void createLotto() {

        for (int i = 0; i < money.getBuyCount(); i++) {
            List<LottoNumber> lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            Output.printBuyLottoNumber(lotto);
            lottos.add(lotto);
        }

    }


    public WinningLottoResult matchLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 지난주 당첨번호와 중복됩니다.");
        }

        WinningLottoResult lottoResult = new WinningLottoResult();
        for (Lotto lotto : lottos) {
            int count = lotto.matchCount(winningLotto);
            lottoResult.match(count, lotto.isContain(bonusNumber));
        }
        return lottoResult;
    }

}
