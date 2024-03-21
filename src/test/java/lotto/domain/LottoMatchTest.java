package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoMatchTest {
    @Test
    @DisplayName("당첨 로또와 맞는 개수 확인")
    void match_num() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(Arrays.asList(1,2,3,4,5,8));
        Lotto lotto4 = new Lotto(Arrays.asList(1,2,3,4,8,9));
        Lotto lotto5 = new Lotto(Arrays.asList(1,2,3,8,9,10));
        Lotto lotto6 = new Lotto(Arrays.asList(1,7,8,9,10,11));

        Lotto winLottoNum = new Lotto(Arrays.asList(1,2,3,4,5,6));
        BonusNum bonusNum = new BonusNum(7, winLottoNum);
        WinLotto winLotto = new WinLotto(winLottoNum, bonusNum);

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1,lotto2,lotto3,lotto4,lotto5,lotto6));

        BuyLottos buyLottos = new BuyLottos(6000,lottos);

        LottoMatch lottoMatch = new LottoMatch();
        lottoMatch.checkRank(buyLottos,winLotto);
        assertAll(
                ()->assertThat(lottoMatch.getRankOfLotto().get(RankMatches.FIRST)).isEqualTo(1),
                ()->assertThat(lottoMatch.getRankOfLotto().get(RankMatches.SECOND)).isEqualTo(1),
                ()->assertThat(lottoMatch.getRankOfLotto().get(RankMatches.THIRD)).isEqualTo(1),
                ()->assertThat(lottoMatch.getRankOfLotto().get(RankMatches.FOURTH)).isEqualTo(1)
                );

    }
}
