package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottosTest {

    @Test
    void 구매_로또_일급_컬렉션_객체_정상_생성_테스트() {
        List<Lotto> lotto = Arrays.asList(new Lotto("1,2,3,4,5,6"));
        BuyLottos buyLottos = new BuyLottos(lotto);
        assertThat(buyLottos).isEqualTo(new BuyLottos(lotto));
    }

    @Test
    void 구매한_로또_당첨_결과_계산_테스트() {
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,7"),
                new Lotto("1,2,3,4,5,8"),
                new Lotto("1,2,3,4,7,8"),
                new Lotto("1,2,3,8,9,10")
        );
        BuyLottos buyLottos = new BuyLottos(lottos);
        List<Rank> ranks = buyLottos.calcLottoRank(winningLotto, new LottoNumber("7"));
        assertThat(ranks).isEqualTo(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH));
    }
}
