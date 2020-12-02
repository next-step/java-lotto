package my.project.lotto.domain;

import my.project.lotto.dto.Lottos;
import my.project.lotto.dto.Ranks;

import java.util.ArrayList;

/**
 * Created : 2020-11-30 오후 3:04
 * Developer : Seo
 */
public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranks getRanks(Lottos lottos) {
        Ranks ranks = new Ranks(new ArrayList<>());
        for (Lotto lotto : lottos.getLottos()) {
            ranks.add(Rank.rank(lotto.count(winningLotto), lotto.contains(bonusNumber)));
        }
        return ranks;
    }

}
