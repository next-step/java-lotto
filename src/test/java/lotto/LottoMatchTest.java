package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    @Test
    @DisplayName("당첨 로또와 맞는 개수 확인")
    void match_num() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(Arrays.asList(1,2,3,4,7,8));
        Lotto lotto4 = new Lotto(Arrays.asList(1,2,3,7,8,9));
        Lotto lotto5 = new Lotto(Arrays.asList(1,2,7,8,9,10));
        Lotto lotto6 = new Lotto(Arrays.asList(1,7,8,9,10,11));
        Lotto winLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1,lotto2,lotto3,lotto4,lotto5,lotto6));

        BuyLottos buyLottos = new BuyLottos(6000,lottos);

        LottoMatch lottoMatch = new LottoMatch();
        lottoMatch.checkRank(buyLottos,winLotto);

        assertThat(lottoMatch.getRankOfLotto()).isEqualTo(Arrays.asList(1,1,1,1));


    }
}
